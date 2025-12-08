package com.coding.rahul.learningRestAPIs.service.impl;

import com.coding.rahul.learningRestAPIs.dto.StudentDto;
import com.coding.rahul.learningRestAPIs.entity.Student;
import com.coding.rahul.learningRestAPIs.repository.StudentRepository;
import com.coding.rahul.learningRestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> studentDtoList = studentList.
                stream().
                map(student ->
                modelMapper.map(student, StudentDto.class))
                .toList();
        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student =   studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "student not found with id : " + id
        ));

        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }
}
