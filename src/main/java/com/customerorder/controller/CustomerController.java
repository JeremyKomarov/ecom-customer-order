package com.customerorder.controller;

import com.customerorder.model.Customer;
import com.customerorder.repository.CustomerRepository;
import com.customerorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public void createCustomer(@RequestBody Customer customer) throws Exception {
        customerService.createCustomer(customer);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody Customer customer) throws Exception {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable Long id) throws Exception {
        customerService.deleteCustomerById(id);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/ids")
    public List<Long> getAllCustomerIdsByFirstName(@RequestParam String firstName) {
        return customerService.getAllCustomerIdsByFirstName(firstName);
    }
}