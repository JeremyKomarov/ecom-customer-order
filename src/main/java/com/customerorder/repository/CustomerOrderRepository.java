package com.customerorder.repository;

import com.customerorder.model.CustomerOrder;
import com.customerorder.model.CustomerOrderRequest;
import com.customerorder.model.CustomerOrderResponse;

import java.util.List;

public interface CustomerOrderRepository {
    void createCustomerOrder(CustomerOrder customerOrder) throws Exception;
    void updateCustomerOrder(CustomerOrder customerOrder) throws Exception;
    void deleteCustomerById(Long id) throws Exception;
    CustomerOrder getCustomerOrderById(Long id);
    List<CustomerOrder> getAllCustomerOrdersById(Long id) throws Exception;
}
