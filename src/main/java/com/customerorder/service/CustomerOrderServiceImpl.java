package com.customerorder.service;

import com.customerorder.model.Customer;
import com.customerorder.model.CustomerOrder;
import com.customerorder.model.CustomerOrderRequest;
import com.customerorder.model.CustomerOrderResponse;
import com.customerorder.repository.CustomerOrderRepository;
import com.customerorder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @Autowired
    CustomerService customerService;

    @Override
    public CustomerOrderResponse createCustomerOrder(CustomerOrderRequest customerOrderRequest) throws Exception {
        Customer selectedCustomer = customerOrderRequest.getCustomer();

        if (selectedCustomer != null) {
            if (selectedCustomer.getId() != null) {

            } else {

            }

        } else {
            throw new Exception("Cant create a customer order with customer null");
        }
    }

    @Override
    public CustomerOrderResponse updateCustomerOrder(CustomerOrderRequest customerOrderRequest) {
        customerOrderRepository.updateCustomerOrder(customerOrderRequest.getCustomerOrder());
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
