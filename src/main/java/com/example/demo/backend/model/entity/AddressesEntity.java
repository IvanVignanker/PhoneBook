package com.example.demo.backend.model.entity;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Transactional(readOnly = true)
public class AddressesEntity {

    @Id
    private Long id;

    @NotBlank
    private String country;

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @NotBlank
    private String houseNumber;

    @NotBlank
    private String apartment;

    @ManyToOne
    private UsersEntity usersEntity;

}
