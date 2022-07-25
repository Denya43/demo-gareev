package com.example.demogareev.dao;

import com.example.demogareev.dto.DeleteTestEntityDto;
import com.example.demogareev.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyRepository extends JpaRepository<TestEntity, Long> {

    Optional<TestEntity> getTestEntityById(Long id);
}
