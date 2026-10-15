package com.customerorder.service;

import com.customerorder.model.Customer;
import com.customerorder.model.CustomerStatus;
import com.customerorder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Long createCustomer(Customer customer) throws Exception {
        //Object Mapper reference
        String customerAsString = objectMapper.writeValueAsString(customer);
        System.out.println("Starting create a customer : " + customerAsString);
        Customer customerFromString = objectMapper.readValue(customerAsString, Customer.class);
        System.out.println(customerFromString.getFirstName());


        if (customer.getCustomerStatus() == CustomerStatus.VIP) {
            List<Customer> vipCustomers = customerRepository.getAllCustomersByStatus(CustomerStatus.VIP);

            if (!(vipCustomers.size() >= 10)) {
                return customerRepository.createCustomer(customer);
            } else {
                throw new Exception("Could not create new customer with status VIP - Out of limit");
            }
        } else {
            return customerRepository.createCustomer(customer);
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception {
        if (customer.getCustomerStatus() == CustomerStatus.VIP) {
            List<Customer> vipCustomers = customerRepository.getAllCustomersByStatus(CustomerStatus.VIP);

            if (!(vipCustomers.size() >= 10)) {
                customerRepository.updateCustomer(customer);
            } else {
                throw new Exception("Could not update new customer with status VIP - Out of limit");
            }
        } else {
            customerRepository.updateCustomer(customer);
        }
    }

    @Override
    public void deleteCustomerById(Long id) throws Exception {
        customerRepository.deleteCustomerById(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public List<Long> getAllCustomerIdsByFirstName(String firstName) {
        return customerRepository.getAllCustomerIdsByFirstName(firstName);
    }
}
