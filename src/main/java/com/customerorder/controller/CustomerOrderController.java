package com.customerorder.controller;

import com.customerorder.model.CustomerOrder;
import com.customerorder.model.CustomerOrderRequest;
import com.customerorder.model.CustomerOrderResponse;
import com.customerorder.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class CustomerOrderController {

    @Autowired
    CustomerOrderService customerOrderService;

    @PostMapping("/create")
    public CustomerOrderResponse createCustomerOrder(@RequestBody CustomerOrderRequest customerOrderRequest) {
        return customerOrderService.createCustomerOrder(customerOrderRequest);
    }

    @PutMapping("/update")
    public CustomerOrderResponse updateCustomerOrder(@RequestBody CustomerOrderRequest customerOrderRequest) {
        return customerOrderService.updateCustomerOrder(customerOrderRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomerOrderById(@PathVariable Long id) {
        customerOrderService.deleteCustomerById(id);
    }

    @GetMapping("/{id}")
    public CustomerOrder getCustomerOrderById(@PathVariable Long id) {
        return customerOrderService.getCustomerOrderById(id);
    }
}
