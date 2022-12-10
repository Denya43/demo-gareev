package com.example.demogareev.service.impl;

import com.example.demogareev.dao.MyRepository;
import com.example.demogareev.dto.AddTestEntityDto;
import com.example.demogareev.dto.ChangeTestEntityNameDto;
import com.example.demogareev.dto.DeleteTestEntityDto;
import com.example.demogareev.exception.ApiInvalidParametersException;
import com.example.demogareev.exception.ApiTestEntityNotFoundException;
import com.example.demogareev.model.TestEntity;
import com.example.demogareev.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;

import static com.example.demogareev.resources.LoggerResources.*;


@Service
@Slf4j
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final MyRepository myRepository;


    @Override
    public Optional<TestEntity> getTestEntityById(Long id) {

        log.trace("ENTRY");

        Optional<TestEntity> result = myRepository.getTestEntityById(id);
        if (!result.isPresent()) {
            log.trace("THROW");
            throw new ApiTestEntityNotFoundException("testEntity doesn't exist");
        }

        log.trace("EXIT");

        return result;
    }

    @Override
    public void addTestEntity(AddTestEntityDto dto) {

        log.trace("ENTRY");

        TestEntity testEntity = new TestEntity(dto);
        myRepository.save(testEntity);

        log.trace("EXIT");
    }

    @Override
    public void changeTestEntityName(ChangeTestEntityNameDto dto) {

        log.trace("ENTRY");

        Optional<TestEntity> optional = myRepository.getTestEntityById(dto.getId());
        if (optional.isPresent()) {
            TestEntity testEntity = optional.get();
            testEntity.setDocumentName(dto.getDocumentName());
            myRepository.save(testEntity);
        } else {
            log.trace("THROW");
            throw new ApiTestEntityNotFoundException("testEntity with this id doesn't exist");
        }

        log.trace("EXIT");
    }

    @Override
    public void deleteTestEntity(DeleteTestEntityDto dto) {

        log.trace("ENTRY");

        try {
            Optional<TestEntity> optional = myRepository.getTestEntityById(dto.getId());
            if (optional.isPresent()) {
                myRepository.deleteById(dto.getId());
            } else {
                log.trace("THROW");
                throw new ApiTestEntityNotFoundException("testEntity with this id doesn't exist");
            }

            log.trace("EXIT");
        } catch (ApiInvalidParametersException e) {
            throw new ApiInvalidParametersException("Required parameters are missing or have incorrect format");
        }
    }
}
