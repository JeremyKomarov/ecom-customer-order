package com.customerorder.repository;

import com.customerorder.model.Student;

public interface StudentRepository {
    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(Long id);
}
