package com.customerorder.model;

import java.util.List;

public class CustomerOrder {
    private Long id;
    private Long customerId;
    private String itemName;
    private Double price;
    private Long deliveryId;

    public CustomerOrder(Long id, Long customerId, String itemName, Double price, Long deliveryId) {
        this.id = id;
        this.customerId = customerId;
        this.itemName = itemName;
        this.price = price;
        this.deliveryId = deliveryId;
    }

    public Long getId() {
        return this.id;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public Double getPrice() {
        return this.price;
    }

    public Long getDeliveryId() {
        return this.deliveryId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public CustomerOrderResponse toCustomerOrderResponse(
            Customer customer,
            List<CustomerOrder> customerOrderList
    ) {
        return new CustomerOrderResponse(
                customer,
                customerOrderList
        );
    }
}
