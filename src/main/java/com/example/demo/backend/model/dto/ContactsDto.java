package com.example.demo.backend.model.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
public class ContactsDto {

    private String fullName;

    private String email;

    private List <String> phoneNumbers;

    private List <AddressesDto> addresses;


}
