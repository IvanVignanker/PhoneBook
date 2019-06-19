package com.example.demo.backend.repo;

import com.example.demo.backend.model.entity.PhoneNumbersEntity;
import com.example.demo.backend.model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumbersRepository extends JpaRepository<PhoneNumbersEntity,Long> {
//    List<PhoneNumbersEntity > getAllUsers(UsersEntity usersEntity);
    List<PhoneNumbersEntity> findAllByUsersEntity(UsersEntity usersEntity);
//    void deleteAllByUsersEntity (UsersEntity usersEntity);

}
