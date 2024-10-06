package com.example.studentRegistration.controller;

import com.example.studentRegistration.model.Student;

import com.example.studentRegistration.service.StudentServiceImpl;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return  ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }



}
