package com.example.demo.backend.service;

import com.example.demo.backend.model.dto.ContactsDto;
import com.example.demo.backend.model.entity.UsersEntity;
import com.example.demo.backend.repo.AddressesRepository;
import com.example.demo.backend.repo.PhoneNumbersRepository;
import com.example.demo.backend.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactsService {

    void createContact (ContactsDto contactsDto);

    void updateContact (Long id, ContactsDto contactsDto);

    void deleteContact (Long id);

    ContactsDto getContact (Long id);

    List<ContactsDto> getAllContacts();

    ContactsDto getContactByName (String name);

    ContactsDto getContactByPhoneNumber (String phoneNumber);

}
