package com.example.demogareev.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTestEntityDto {

    @NotNull
    private String documentName;

    @NotNull
    private String documentDate;

    @NotNull
    private Long dictionaryValueId;
}
