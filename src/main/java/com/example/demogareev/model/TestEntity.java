package com.example.demogareev.model;

import com.example.demogareev.dto.AddTestEntityDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public TestEntity(AddTestEntityDto addTestEntityDto) {
        this.documentName = addTestEntityDto.getDocumentName();
        this.documentDate = addTestEntityDto.getDocumentDate();
        this.dictionaryValueId = addTestEntityDto.getDictionaryValueId();
    }
}
