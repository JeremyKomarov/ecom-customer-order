package com.customerorder.service;

import com.customerorder.model.Customer;

import java.util.List;

public interface CustomerService {
    Long createCustomer(Customer customer) throws Exception;
    void updateCustomer(Customer customer) throws Exception;
    void deleteCustomerById(Long id) throws Exception;
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    List<Long> getAllCustomerIdsByFirstName(String firstName);
}
