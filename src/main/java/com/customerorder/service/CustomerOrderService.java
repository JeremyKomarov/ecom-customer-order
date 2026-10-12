package com.customerorder.service;

import com.customerorder.model.CustomerOrder;

public interface CustomerOrderService {
    void createCustomerOrder(CustomerOrder customerOrder);
    void updateCustomerOrder(CustomerOrder customerOrder);
    void deleteCustomerById(Long id);
    CustomerOrder getCustomerOrderById(Long id);
}
