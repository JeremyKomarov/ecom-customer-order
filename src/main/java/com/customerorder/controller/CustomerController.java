package com.customerorder.controller;

import com.customerorder.model.Customer;
import com.customerorder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/create")
    public void createCustomer(@RequestBody Customer customer) {
        customerRepository.createCustomer(customer);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable Long id) {
        customerRepository.deleteCustomerById(id);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.getCustomerById(id);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @GetMapping("/ids")
    public List<Long> getAllCustomerIdsByFirstName(@RequestParam String firstName) {
        return customerRepository.getAllCustomerIdsByFirstName(firstName);
    }
}