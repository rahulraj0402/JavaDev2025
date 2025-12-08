package com.coding.rahul.learningRestAPIs.service;

import com.coding.rahul.learningRestAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);
}
