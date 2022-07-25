package com.example.demogareev.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeTestEntityNameDto {

    @NotNull
    private Long id;

    @NotNull
    private String documentName;
}
