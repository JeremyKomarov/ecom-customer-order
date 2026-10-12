package com.customerorder.model;

public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private CustomerStatus customerStatus;

    public Customer(Long id, String firstName, String lastName, String email, CustomerStatus customerStatus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.customerStatus = customerStatus;
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

    public CustomerStatus getCustomerStatus() {
        return this.customerStatus;
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

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }
}
