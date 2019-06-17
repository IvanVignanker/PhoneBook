package com.example.demo.backend.repo;

import com.example.demo.backend.model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<UsersEntity, Long> {


    List<Long> getAllIds ();
    UsersEntity findUsersEntityByFullName (String fullName);
}
