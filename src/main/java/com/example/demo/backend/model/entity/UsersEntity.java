package com.example.demo.backend.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
public class UsersEntity {

    @Id
    private Long id;

    @NotBlank
    private String fullName;

    @Email
    private String email;

}
