package com.customerorder.service;

import com.customerorder.model.CustomerOrder;
import com.customerorder.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @Override
    public void createCustomerOrder(CustomerOrder customerOrder) {
        customerOrderRepository.createCustomerOrder(customerOrder);
    }

    @Override
    public void updateCustomerOrder(CustomerOrder customerOrder) {
        customerOrderRepository.updateCustomerOrder(customerOrder);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerOrderRepository.deleteCustomerById(id);
    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        return customerOrderRepository.getCustomerOrderById(id);
    }
}
