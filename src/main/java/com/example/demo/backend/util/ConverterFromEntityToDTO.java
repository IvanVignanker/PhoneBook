package com.example.demo.backend.util;

import com.example.demo.backend.model.dto.AddressesDto;
import com.example.demo.backend.model.dto.ContactsDto;
import com.example.demo.backend.model.entity.AddressesEntity;
import com.example.demo.backend.model.entity.PhoneNumbersEntity;
import com.example.demo.backend.model.entity.UsersEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConverterFromEntityToDTO {
    public ContactsDto converterFromUserEntityToContactDTO(
            UsersEntity usersEntity, List<PhoneNumbersEntity> phoneNumbersEntities,
            List<AddressesEntity> addressesEntities) {
        return ContactsDto.builder().fullName(usersEntity.getFullName())
        .email(usersEntity.getEmail()).phoneNumbers(phoneNumbersEntities.stream()
                        .map(PhoneNumbersEntity::getPhoneNumber).collect(Collectors.toList()))
        .addresses(addressesEntities.stream().map(addressesEntity
                -> converterAddressEntityToAddressDTO(addressesEntity)).collect(Collectors.toList()))
                .build();
    }

    public AddressesDto converterAddressEntityToAddressDTO(AddressesEntity addressesEntity) {
        return AddressesDto.builder().country(addressesEntity.getCountry())
                .city(addressesEntity.getCity()).street(addressesEntity.getStreet())
                .houseNumber(addressesEntity.getHouseNumber()).apartment(addressesEntity.getApartment())
                .build();
    }
}
