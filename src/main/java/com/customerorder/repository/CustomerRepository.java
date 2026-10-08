package com.customerorder.repository;

import com.customerorder.model.Customer;

public interface CustomerRepository {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerById(Long id);
}
