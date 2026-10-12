package com.customerorder.repository;

import com.customerorder.model.CustomerOrder;
import com.customerorder.repository.mapper.CustomerOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerOrderRepositoryImpl implements CustomerOrderRepository{
    private static final String CUSTOMER_ORDER_TABLE_NAME = "customer_order";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createCustomerOrder(CustomerOrder customerOrder) {
        String sql = "INSERT INTO " + CUSTOMER_ORDER_TABLE_NAME +
                     " (customer_id, item_name, price) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                customerOrder.getCustomerId(),
                customerOrder.getItemName(),
                customerOrder.getPrice()
        );
    }

    @Override
    public void updateCustomerOrder(CustomerOrder customerOrder) {
        String sql = "UPDATE " + CUSTOMER_ORDER_TABLE_NAME +
                " SET customer_id = ?, item_name = ?, price = ?" +
                " WHERE id = ?";

        jdbcTemplate.update(
                sql,
                customerOrder.getCustomerId(),
                customerOrder.getItemName(),
                customerOrder.getPrice(),
                customerOrder.getId()
        );
    }

    @Override
    public void deleteCustomerById(Long id) {
        String sql = "DELETE FROM " + CUSTOMER_ORDER_TABLE_NAME +
                " WHERE id = ?";

        jdbcTemplate.update(
                sql,
                id
        );
    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME +
                     " WHERE id = ?";

        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    new CustomerOrderMapper(),
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Not found");
            return null;
        }
    }
}
