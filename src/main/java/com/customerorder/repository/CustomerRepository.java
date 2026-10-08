package com.customerorder.repository;

import com.customerorder.model.Customer;

import java.util.List;

public interface CustomerRepository {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
}
