package com.coding.rahul.learningRestAPIs.service.impl;

import com.coding.rahul.learningRestAPIs.dto.AddStudentRequestDto;
import com.coding.rahul.learningRestAPIs.dto.StudentDto;
import com.coding.rahul.learningRestAPIs.entity.Student;
import com.coding.rahul.learningRestAPIs.repository.StudentRepository;
import com.coding.rahul.learningRestAPIs.service.StudentService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        // 1. check if the student is available on database or not
        if (!studentRepository.existsById(id)){
            throw new IllegalArgumentException("student with ID : " + id + " is not present on database");
        }
        // 2. if present then delete
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student =   studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "student not found with id : " + id
        ));
        modelMapper.map(addStudentRequestDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }


    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student =   studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "student not found with id : " + id
        ));
        updates.forEach((feild , value) -> {
            switch (feild) {
                case "name" :
                    student.setName((String) value);
                break;
                case "email" :
                    student.setEmail((String) value);
                break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });

        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }
}
