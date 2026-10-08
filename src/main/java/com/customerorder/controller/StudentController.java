package com.customerorder.controller;

import com.customerorder.model.Student;
import com.customerorder.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.getStudentById(id);
    }

    @GetMapping("/all")
    public List<Student> getAllStudentsByFirstName(@RequestParam String firstName) {
        return studentRepository.getAllStudentsByFirstName(firstName);
    }

    @GetMapping("/all/email")
    public List<String> getAllStudentsEmailsByFirstName(@RequestParam String firstName) {
        return studentRepository.getAllStudentsEmailsByFirstName(firstName);
    }

    @GetMapping("/allByIds")
    public List<Student> getAllStudentsByIds(@RequestParam List<Long> ids) {
        return studentRepository.getAllStudentsByIds(ids);
    }
}
