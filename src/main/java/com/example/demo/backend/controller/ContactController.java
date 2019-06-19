package com.example.demo.backend.controller;


import com.example.demo.backend.model.dto.ContactsDto;
import com.example.demo.backend.model.entity.PhoneNumbersEntity;
import com.example.demo.backend.model.entity.UsersEntity;
import com.example.demo.backend.repo.AddressesRepository;
import com.example.demo.backend.repo.PhoneNumbersRepository;
import com.example.demo.backend.repo.UsersRepository;
import com.example.demo.backend.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    ContactsService contactsService;

    @GetMapping(value = "/getAllUsers")
    public List<ContactsDto> getAllUsers() {
        return contactsService.getAllContacts();
    }

    @GetMapping(value = "/getUserById")
    public ContactsDto getUserById(Long id) {
        return contactsService.getContact(id);
    }

//    @GetMapping(value = "/phoneNumber")
//    public List<PhoneNumbersRepository> getPhoneNumbersRepository() {
//        return contactsService.getPhoneNumbersRepository();
//    }
//
//    @GetMapping(value = "/address")
//    public AddressesRepository getAddressesRepository() {
//                return contactsService.getAddressesRepository();
//    }

}
