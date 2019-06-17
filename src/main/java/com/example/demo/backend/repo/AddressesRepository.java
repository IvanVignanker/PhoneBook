package com.example.demo.backend.repo;

import com.example.demo.backend.model.entity.AddressesEntity;
import com.example.demo.backend.model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressesRepository extends JpaRepository <AddressesEntity, Long> {

    List<AddressesEntity> findAllByUsersEntity (UsersEntity usersEntity);

    void deleteAllByUsersEntity (UsersEntity usersEntity);
}
