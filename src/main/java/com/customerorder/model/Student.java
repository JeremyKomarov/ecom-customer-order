package com.customerorder.model;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private StudentPaymentMethod studentPaymentMethod;

    public Student(Long id, String firstName, String lastName, String email, StudentPaymentMethod studentPaymentMethod) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentPaymentMethod = studentPaymentMethod;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public StudentPaymentMethod getStudentPaymentMethod() {
        return this.studentPaymentMethod;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStudentPaymentMethod(StudentPaymentMethod studentPaymentMethod) {
        this.studentPaymentMethod = studentPaymentMethod;
    }
}
