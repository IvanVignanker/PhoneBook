package com.example.demo.backend.repo;

import com.example.demo.backend.model.entity.PhoneNumbersEntity;
import com.example.demo.backend.model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneNumbersRepository extends JpaRepository<PhoneNumbersEntity,Long> {
    List<PhoneNumbersEntity > getAllUsers(UsersEntity usersEntity);

    PhoneNumbersEntity getPhoneNumbersEntityByPhoneNumber (String phoneNumber);

    void deleteAllByUsersEntity (UsersEntity usersEntity);

}
