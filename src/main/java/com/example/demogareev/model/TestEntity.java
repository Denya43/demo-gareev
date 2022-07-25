package com.example.demogareev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
//@Table(name = "test_entity")
//@AllArgsConstructor
//@NoArgsConstructor
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(nullable = false)
    private String documentName;

    @Column(nullable = false)
    private String documentDate;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dictionaryValueId;
}
