package com.customerorder.controller;

import com.customerorder.model.Student;
import com.customerorder.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/create")
    public void createStudent(@RequestBody Student student) {
        studentRepository.createStudent(student);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        studentRepository.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentRepository.deleteStudentById(id);
    }
}
