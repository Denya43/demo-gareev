package com.example.demogareev.service.impl;

import com.example.demogareev.controller.TestController;
import com.example.demogareev.dao.MyRepository;
import com.example.demogareev.dto.AddTestEntityDto;
import com.example.demogareev.dto.ChangeTestEntityNameDto;
import com.example.demogareev.dto.DeleteTestEntityDto;
import com.example.demogareev.exception.ApiInvalidParametersException;
import com.example.demogareev.model.TestEntity;
import com.example.demogareev.exception.ApiTestEntityNotFoundException;
import com.example.demogareev.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.demogareev.resources.LoggerResources.*;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final static Logger LOG = Logger.getLogger(TestController.class.getCanonicalName());

    private final MyRepository myRepository;

    @Override
    public void addTestEntity(AddTestEntityDto dto) {

        LOG.log(Level.INFO, ENTRY);

        TestEntity testEntity = new TestEntity();
        testEntity.setDocumentName(dto.getDocumentName());
        testEntity.setDocumentDate(dto.getDocumentDate());
        testEntity.setDictionaryValueId(dto.getDictionaryValueId());
        myRepository.save(testEntity);

        LOG.log(Level.INFO, EXIT);
    }

    @Override
    public void changeTestEntityName(ChangeTestEntityNameDto dto) {

        LOG.log(Level.INFO, ENTRY);

        Optional<TestEntity> optional = myRepository.getTestEntityById(dto.getId());
        if (optional.isPresent()) {
            TestEntity testEntity = optional.get();
            testEntity.setDocumentName(dto.getDocumentName());
            myRepository.save(testEntity);
        } else {
            LOG.log(Level.INFO, THROW);
            throw new ApiTestEntityNotFoundException("testEntity with this id doesn't exist");
        }

        LOG.log(Level.INFO, EXIT);
    }

    @Override
    public void deleteTestEntity(DeleteTestEntityDto dto) {

        LOG.log(Level.INFO, ENTRY);

        try {
            Optional<TestEntity> optional = myRepository.getTestEntityById(dto.getId());
            if (optional.isPresent()) {
                myRepository.deleteById(dto.getId());
            } else {
                LOG.log(Level.INFO, THROW);
                throw new ApiTestEntityNotFoundException("testEntity with this id doesn't exist");
            }

            LOG.log(Level.INFO, EXIT);
        } catch (ApiInvalidParametersException e) {
            throw new ApiInvalidParametersException("Required parameters are missing or have incorrect format");
        }
    }
}
