package com.example.controller;

import com.example.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return student;
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return student;
    }

    @DeleteMapping("/delete/{id}")
    public Long deleteStudentById(@PathVariable Long id) {
        return id;
    }
}
