package com.customerorder.service;

import com.customerorder.model.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    List<Long> getAllCustomerIdsByFirstName(String firstName);
}
