package com.example.demo.backend.service;

import com.example.demo.backend.model.dto.AddressesDto;
import com.example.demo.backend.model.dto.ContactsDto;
import com.example.demo.backend.model.entity.AddressesEntity;
import com.example.demo.backend.model.entity.PhoneNumbersEntity;
import com.example.demo.backend.model.entity.UsersEntity;
import com.example.demo.backend.repo.AddressesRepository;
import com.example.demo.backend.repo.PhoneNumbersRepository;
import com.example.demo.backend.repo.UsersRepository;
import com.example.demo.backend.util.ConverterFromEntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PhoneNumbersRepository phoneNumbersRepository;


    @Autowired
    AddressesRepository addressesRepository;

    @Autowired
    ConverterFromEntityToDTO converterFromEntityToDTO;

//    @Transactional
//    public void createContact(ContactsDto contactsDto) {
//        UsersEntity usersEntity = UsersEntity.builder()
//                .fullName(contactsDto.getFullName())
//                .email(contactsDto.getEmail())
//                .build();
//
//        List<PhoneNumbersEntity> phoneNumbersEntities =
//                createPhoneNumbersFromContactDto(contactsDto, usersEntity);
//
//        List<AddressesEntity> addressesEntities =
//                createAddressesFromContactDto(contactsDto, usersEntity);
//
//        usersRepository.save(usersEntity);
//        phoneNumbersRepository.saveAll(phoneNumbersEntities);
//        addressesRepository.saveAll(addressesEntities);
//    }
//
//    private AddressesEntity convertAddressDtoToAddress(UsersEntity usersEntity, AddressesDto addressesEntity) {
//        return new AddressesEntity(0L,  addressesEntity.getCountry(), addressesEntity.getCity(),
//                addressesEntity.getStreet(),
//                addressesEntity.getHouseNumber(), addressesEntity.getApartment(),usersEntity);
//    }
//

    @Override
    @Transactional(readOnly = true)
    public List<ContactsDto> getAllContacts() {
        List<Long> ids = usersRepository.getAllIds();
        return ids.stream().map(id -> getContact(id)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ContactsDto getContact(Long id) {
        UsersEntity usersEntity = usersRepository.findById(id).orElseThrow(null);
        List<AddressesEntity> addressesEntities
                = addressesRepository.findAllByUsersEntity(usersEntity);
        List<PhoneNumbersEntity> phoneNumbersEntities
                = phoneNumbersRepository.findAllByUsersEntity(usersEntity);
        return converterFromEntityToDTO.converterFromUserEntityToContactDTO(
                usersEntity, phoneNumbersEntities, addressesEntities);
    }

//    @Override
//    @Transactional(readOnly = true)
//    public ContactsDto getContactByName(String name) {
//        UsersEntity usersEntity = usersRepository.findUsersEntityByFullName(name);
//        return getContact(usersEntity.getId());
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public ContactsDto getContactByPhoneNumber(String number) {
//        PhoneNumbersEntity phoneNumbersEntity = phoneNumbersRepository.getPhoneNumbersEntityByPhoneNumber(number);
//        return getContact(phoneNumbersEntity.getUsersEntity().getId());
//    }
}
