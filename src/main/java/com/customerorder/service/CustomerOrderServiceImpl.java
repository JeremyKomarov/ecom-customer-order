package com.customerorder.service;

import com.customerorder.model.Customer;
import com.customerorder.model.CustomerOrder;
import com.customerorder.model.CustomerOrderRequest;
import com.customerorder.model.CustomerOrderResponse;
import com.customerorder.repository.CustomerOrderRepository;
import com.customerorder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @Autowired
    CustomerService customerService;

    @Override
    public CustomerOrderResponse createCustomerOrder(CustomerOrderRequest customerOrderRequest) throws Exception {
        Customer selectedCustomer = customerOrderRequest.getCustomer();
        Customer customerForResponse = null;

        if (selectedCustomer != null) {
            if (selectedCustomer.getId() != null) {
                Customer existingCustomer = customerService.getCustomerById(selectedCustomer.getId());

                if(existingCustomer != null) {
                    customerOrderRepository.createCustomerOrder(customerOrderRequest.toCustomerOrder());
                    customerForResponse = existingCustomer;
                } else {
                    throw new Exception("Cant create customer order with non exisitng id " + selectedCustomer.getId());
                }
            } else {
                Long createdCustomerId = customerService.createCustomer(selectedCustomer);
                CustomerOrder customerOrderToCreate = customerOrderRequest.toCustomerOrder();
                customerOrderToCreate.setCustomerId(createdCustomerId);
                customerOrderRepository.createCustomerOrder(customerOrderToCreate);
                customerForResponse = customerService.getCustomerById(createdCustomerId);
            }

        } else {
            throw new Exception("Cant create a customer order with customer null");
        }

        List<CustomerOrder> customerOrderListForResponse = customerOrderRepository.getAllCustomerOrdersById(customerForResponse.getId());
        CustomerOrderResponse customerOrderResponse = customerOrderRequest.getCustomerOrder().toCustomerOrderResponse(
                customerForResponse,
                customerOrderListForResponse
        );

        return customerOrderResponse;
    }

    @Override
    public CustomerOrderResponse updateCustomerOrder(CustomerOrder customerOrder) throws Exception {
        Customer customerForResponse = null;

        if(customerOrder != null) {
            CustomerOrder existingCustomerOrder = customerOrderRepository.getCustomerOrderById(customerOrder.getId());

            if (existingCustomerOrder != null) {
                Long existingCustomerOrderId = existingCustomerOrder.getCustomerId();
                Customer existingCustomer = customerService.getCustomerById(existingCustomerOrderId);
                if (existingCustomer != null) {
                    if (customerOrder.getId().equals(existingCustomer.getId()))  {
                        customerOrderRepository.updateCustomerOrder(customerOrder);
                        customerForResponse = existingCustomer;
                    } else {
                        throw new Exception("This order does not belong to this customer");
                    }
                } else {
                    throw new Exception("There is no customer with the customer id");
                }
            } else {
                throw new Exception("There is no order with this id");
            }
        } else {
            throw new Exception("There is no customer order in the request");
        }

        List<CustomerOrder> customerOrderListForResponse = customerOrderRepository.getAllCustomerOrdersById(customerForResponse.getId());

        CustomerOrderResponse customerOrderResponse = customerOrder.toCustomerOrderResponse(
                customerForResponse,
                customerOrderListForResponse
        );

        return customerOrderResponse;
    }

    @Override
    public void deleteCustomerById(Long id) throws Exception {
        customerOrderRepository.deleteCustomerById(id);
    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        return customerOrderRepository.getCustomerOrderById(id);
    }
}
