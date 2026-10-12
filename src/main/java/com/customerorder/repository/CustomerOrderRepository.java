package com.customerorder.repository;

import com.customerorder.model.CustomerOrder;

public interface CustomerOrderRepository {
    void createCustomerOrder(CustomerOrder customerOrder);
    void updateCustomerOrder(CustomerOrder customerOrder);
    void deleteCustomerById(Long id);
    CustomerOrder getCustomerOrderById(Long id);
}
