package com.coding.rahul.learningRestAPIs.controller;

import com.coding.rahul.learningRestAPIs.dto.StudentDto;
import com.coding.rahul.learningRestAPIs.entity.Student;
import com.coding.rahul.learningRestAPIs.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public List<Student> getStudent(){
       return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(){
        return new StudentDto(4L, "ROHAN RAJ", "rohan@gmail.com");
    }

}
