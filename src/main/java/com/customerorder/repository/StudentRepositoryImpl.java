package com.customerorder.repository;

import com.customerorder.model.Student;
import com.customerorder.repository.mapper.CustomerMapper;
import com.customerorder.repository.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static final String STUDENT_TABLE_NAME = "student";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createStudent(Student student) {
        String sql = "INSERT INTO " + STUDENT_TABLE_NAME +
                     " (first_name, last_name, email) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE " + STUDENT_TABLE_NAME +
                     " SET first_name = ?, last_name = ?, email = ?" +
                     " WHERE id = ?";

        jdbcTemplate.update(
                sql,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getId()
        );
    }

    @Override
    public void deleteStudentById(Long id) {
        String sql = "DELETE FROM " + STUDENT_TABLE_NAME +
                     " WHERE id = ?";

        jdbcTemplate.update(
                sql,
                id
        );
    }

    @Override
    public Student getStudentById(Long id) {
        String sql = "SELECT * FROM " + STUDENT_TABLE_NAME +
                " WHERE id = ?";

        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    new StudentMapper(),
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudentsByFirstName(String firstName) {
        String sql = "SELECT * FROM " + STUDENT_TABLE_NAME +
                " WHERE first_name = ?";
        try {
            return jdbcTemplate.query(
                    sql,
                    new StudentMapper(),
                    firstName
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<String> getAllStudentsEmailsByFirstName(String firstName) {
        String sql = "SELECT email FROM " + STUDENT_TABLE_NAME +
                " WHERE first_name = ?";
        try {
            return jdbcTemplate.queryForList(
                    sql,
                    String.class,
                    firstName
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudentsByIds(List<Long> ids) {
        String stringedIds = ids.toString().replace("[", "").replace("]", "");
        String sql = "SELECT * FROM " + STUDENT_TABLE_NAME +
                " WHERE id IN (" + stringedIds + ")";

        try {
            return jdbcTemplate.query(
                    sql,
                    new StudentMapper()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
