package com.example.demogareev.service;

import com.example.demogareev.dto.AddTestEntityDto;
import com.example.demogareev.dto.ChangeTestEntityNameDto;
import com.example.demogareev.dto.DeleteTestEntityDto;

public interface TestService {

    void addTestEntity(AddTestEntityDto dto);

    void changeTestEntityName(ChangeTestEntityNameDto dto);

    void deleteTestEntity(DeleteTestEntityDto dto);
}
