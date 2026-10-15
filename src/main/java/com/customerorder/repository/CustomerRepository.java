package com.customerorder.repository;

import com.customerorder.model.Customer;
import com.customerorder.model.CustomerStatus;

import java.util.List;

public interface CustomerRepository {
    Long createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    List<Long> getAllCustomerIdsByFirstName(String firstName);
    List<Customer> getAllCustomersByStatus(CustomerStatus customerStatus);
}