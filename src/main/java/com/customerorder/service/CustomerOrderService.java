package com.customerorder.service;

import com.customerorder.model.CustomerOrder;
import com.customerorder.model.CustomerOrderRequest;
import com.customerorder.model.CustomerOrderResponse;

public interface CustomerOrderService {
    CustomerOrderResponse createCustomerOrder(CustomerOrderRequest customerOrderRequest) throws Exception;
    CustomerOrderResponse updateCustomerOrder(CustomerOrderRequest customerOrderRequest);
    void deleteCustomerById(Long id);
    CustomerOrder getCustomerOrderById(Long id);
}
