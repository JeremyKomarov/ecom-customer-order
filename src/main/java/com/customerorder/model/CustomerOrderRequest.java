package com.customerorder.model;

public class CustomerOrderRequest {
    private Customer customer;
    private CustomerOrder customerOrder;

    public CustomerOrderRequest(Customer customer, CustomerOrder customerOrder) {
        this.customer = customer;
        this.customerOrder = customerOrder;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public CustomerOrder getCustomerOrder() {
        return this.customerOrder;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }


    public CustomerOrder toCustomerOrder() {
        return new CustomerOrder(
                this.getCustomerOrder().getId(),
                this.getCustomer().getId(),
                this.getCustomerOrder().getItemName(),
                this.getCustomerOrder().getPrice(),
                this.getCustomerOrder().getDeliveryId()
        );
    }
}
