package com.customerorder.repository;

import com.customerorder.model.Student;

import java.util.List;

public interface StudentRepository {
    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(Long id);
    Student getStudentById(Long id);
    List<Student> getAllStudentsByFirstName(String firstName);
    List<String> getAllStudentsEmailsByFirstName(String firstName);
    List<Student> getAllStudentsByIds(List<Long> ids);
}
