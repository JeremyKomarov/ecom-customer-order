package com.customerorder.controller;

import com.customerorder.model.CustomerOrder;
import com.customerorder.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class CustomerOrderController {

    @Autowired
    CustomerOrderService customerOrderService;

    @PostMapping("/create")
    public void createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        customerOrderService.createCustomerOrder(customerOrder);
    }

    @PutMapping("/update")
    public void updateCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        customerOrderService.updateCustomerOrder(customerOrder);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomerOrderById(@PathVariable Long id) {
        customerOrderService.deleteCustomerById(id);
    }

    @GetMapping("/{id}")
    public void getCustomerOrderById(@PathVariable Long id) {
        customerOrderService.getCustomerOrderById(id);
    }
}
