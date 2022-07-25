package com.example.demogareev.controller;

import com.example.demogareev.dao.MyRepository;
import com.example.demogareev.dto.AddTestEntityDto;
import com.example.demogareev.dto.ChangeTestEntityNameDto;
import com.example.demogareev.dto.DeleteTestEntityDto;
import com.example.demogareev.dto.response.TestEntityResponse;
import com.example.demogareev.exception.ApiTestEntityNotFoundException;
import com.example.demogareev.model.TestEntity;
import com.example.demogareev.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.demogareev.resources.LoggerResources.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final static Logger LOG = Logger.getLogger(TestController.class.getCanonicalName());

    private final MyRepository myRepository;

    @Autowired
    private final TestService testService;



    @GetMapping("/get")
    public Optional<TestEntity> getTestEntityByName(Long id) {

        LOG.log(Level.INFO, ENTRY);

        Optional<TestEntity> result = myRepository.getTestEntityById(id);
        if (!result.isPresent()) {
            LOG.log(Level.INFO, THROW);
            throw new ApiTestEntityNotFoundException("testEntity doesn't exist");
        }
        LOG.log(Level.INFO, EXIT);

        return result;
    }

    @GetMapping("/user/all")
    public List<TestEntity> allUsers() {
        return myRepository.findAll();
    }

    @PostMapping(value = "/add", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TestEntityResponse> addTestEntity(@Valid @RequestBody AddTestEntityDto dto) {

        LOG.log(Level.INFO, ENTRY);

        testService.addTestEntity(dto);

        LOG.log(Level.INFO, EXIT);

        return ResponseEntity.status(HttpStatus.OK).body(
                new TestEntityResponse(true, LocalDateTime.now(), "OK"));
    }

    @PatchMapping(value = "/change", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TestEntityResponse> changeTestEntityName(@Valid @RequestBody ChangeTestEntityNameDto dto) {

        LOG.log(Level.INFO, ENTRY);

        testService.changeTestEntityName(dto);

        LOG.log(Level.INFO, EXIT);

        return ResponseEntity.status(HttpStatus.OK).body(
                new TestEntityResponse(true, LocalDateTime.now(), "OK"));
    }

    @DeleteMapping(value = "/delete", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TestEntityResponse> deleteTestEntity(@RequestBody DeleteTestEntityDto dto) {

        LOG.log(Level.INFO, ENTRY);

        testService.deleteTestEntity(dto);

        LOG.log(Level.INFO, EXIT);

        return ResponseEntity.status(HttpStatus.OK).body(
                new TestEntityResponse(true, LocalDateTime.now(), "OK"));
    }
}
