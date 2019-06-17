package com.example.demo.backend.model.dto;

import lombok.*;

@Data
@Builder
@ToString
public class AddressesDto {

    private String country;

    private String city;

    private String street;

    private String houseNumber;

    private String apartment;
}
