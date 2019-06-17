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
public class PhoneNumbersEntity {

    @Id
    private Long id;

    @NotBlank
    private String phoneNumber;

    @ManyToOne
    private UsersEntity usersEntity;
}
