package com.example.demogareev.controller;

import com.example.demogareev.dto.AddTestEntityDto;
import com.example.demogareev.dto.ChangeTestEntityNameDto;
import com.example.demogareev.dto.DeleteTestEntityDto;
import com.example.demogareev.dto.response.TestEntityResponse;
import com.example.demogareev.exception.ApiTestEntityNotFoundException;
import com.example.demogareev.model.TestEntity;
import com.example.demogareev.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import static jdk.nashorn.internal.objects.NativeMath.log;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/test")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/get")
    public Optional<TestEntity> getTestEntityByName(Long id) {
        return testService.getTestEntityById(id);
    }

    @PostMapping(value = "/add", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TestEntityResponse> addTestEntity(@Valid @RequestBody AddTestEntityDto dto) {

        log(Level.INFO, ENTRY);

        testService.addTestEntity(dto);

        log(Level.INFO, EXIT);

        return ResponseEntity.status(HttpStatus.OK).body(
                new TestEntityResponse(true, LocalDateTime.now(), "OK"));
    }

    @PatchMapping(value = "/change", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TestEntityResponse> changeTestEntityName(@Valid @RequestBody ChangeTestEntityNameDto dto) {

        log(Level.INFO, ENTRY);

        testService.changeTestEntityName(dto);

        log(Level.INFO, EXIT);

        return ResponseEntity.status(HttpStatus.OK).body(
                new TestEntityResponse(true, LocalDateTime.now(), "OK"));
    }

    @DeleteMapping(value = "/delete", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TestEntityResponse> deleteTestEntity(@RequestBody DeleteTestEntityDto dto) {

        log(Level.INFO, ENTRY);

        testService.deleteTestEntity(dto);

        log(Level.INFO, EXIT);

        return ResponseEntity.status(HttpStatus.OK).body(
                new TestEntityResponse(true, LocalDateTime.now(), "OK"));
    }
}
