package com.example.demogareev.dao;

import com.example.demogareev.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.Document;
import java.lang.annotation.Documented;
import java.util.Optional;

@Repository
public interface MyRepository extends JpaRepository<TestEntity, Long> {

    Optional<TestEntity> getTestEntityById(Long id);

}
