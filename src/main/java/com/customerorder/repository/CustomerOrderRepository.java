package com.customerorder.repository;

import com.customerorder.model.CustomerOrder;
import com.customerorder.model.CustomerOrderRequest;
import com.customerorder.model.CustomerOrderResponse;

public interface CustomerOrderRepository {
    CustomerOrder createCustomerOrder(CustomerOrder customerOrder);
    CustomerOrder updateCustomerOrder(CustomerOrder customerOrder);
    void deleteCustomerById(Long id);
    CustomerOrder getCustomerOrderById(Long id);
}
