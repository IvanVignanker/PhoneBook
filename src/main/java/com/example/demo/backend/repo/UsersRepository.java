package com.example.demo.backend.repo;

import com.example.demo.backend.model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    @Query("select usr.id from UsersEntity usr")
    List<Long> getAllIds ();
    List<UsersEntity> findAllByFullName(String fullName);
}
