package com.example.demogareev.service;

import com.example.demogareev.dto.AddTestEntityDto;
import com.example.demogareev.dto.ChangeTestEntityNameDto;
import com.example.demogareev.dto.DeleteTestEntityDto;
import com.example.demogareev.model.TestEntity;

import java.util.Optional;

public interface TestService {

    Optional<TestEntity> getTestEntityById(Long id);

    void addTestEntity(AddTestEntityDto dto);

    void changeTestEntityName(ChangeTestEntityNameDto dto);

    void deleteTestEntity(DeleteTestEntityDto dto);
}
