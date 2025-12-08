package com.coding.rahul.learningRestAPIs.controller;

import com.coding.rahul.learningRestAPIs.dto.StudentDto;
import com.coding.rahul.learningRestAPIs.entity.Student;
import com.coding.rahul.learningRestAPIs.repository.StudentRepository;
import com.coding.rahul.learningRestAPIs.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentDto> getStudent(){
       return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping


}
