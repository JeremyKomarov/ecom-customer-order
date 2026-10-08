package com.example.repository;

import com.example.model.Student;

public interface StudentRepository {
    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(Long id);
}
