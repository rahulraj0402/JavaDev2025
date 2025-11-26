package com.coding.rahul.learningRestAPIs.dto;

import lombok.*;
@Data
public class StudentDto {
    private Long id;
    private String name;
    private String email;

    public StudentDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
