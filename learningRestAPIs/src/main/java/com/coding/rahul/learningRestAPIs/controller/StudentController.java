package com.coding.rahul.learningRestAPIs.controller;

import com.coding.rahul.learningRestAPIs.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/student")
    public StudentDto getStudent(){
       return new StudentDto(12L,"Rahul raj", "rahul3004rt@gmail.com");
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(){
        return new StudentDto(4L, "ROHAN RAJ", "rohan@gmail.com");
    }

}
