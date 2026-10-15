package com.customerorder.repository;

import com.customerorder.model.CustomerOrder;
import com.customerorder.repository.mapper.CustomerOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerOrderRepositoryImpl implements CustomerOrderRepository{
    private static final String CUSTOMER_ORDER_TABLE_NAME = "customer_order";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createCustomerOrder(CustomerOrder customerOrder) throws Exception {
        String sql = "INSERT INTO " + CUSTOMER_ORDER_TABLE_NAME +
                     " (customer_id, item_name, price) VALUES (?, ?, ?)";

        try {
            jdbcTemplate.update(
                    sql,
                    customerOrder.getCustomerId(),
                    customerOrder.getItemName(),
                    customerOrder.getPrice()
            );
        } catch (Exception e) {
            throw new Exception("Something went wrong");
        }
    }

    @Override
    public void updateCustomerOrder(CustomerOrder customerOrder) throws Exception {
        String sql = "UPDATE " + CUSTOMER_ORDER_TABLE_NAME +
                " SET customer_id = ?, item_name = ?, price = ?" +
                " WHERE id = ?";

        try {
            jdbcTemplate.update(
                    sql,
                    customerOrder.getCustomerId(),
                    customerOrder.getItemName(),
                    customerOrder.getPrice(),
                    customerOrder.getId()
            );
        } catch (Exception e) {
            throw new Exception("Something went wrong");
        }
    }

    @Override
    public void deleteCustomerById(Long id) throws Exception {
        String sql = "DELETE FROM " + CUSTOMER_ORDER_TABLE_NAME +
                " WHERE id = ?";

        try {
            jdbcTemplate.update(
                    sql,
                    id
            );
        } catch (Exception e) {
            throw new Exception("Something went wrong");
        }
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

    @Override
    public List<CustomerOrder> getAllCustomerOrdersById(Long id) throws Exception {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME +
                " WHERE customer_id = ?";

        try {
            return jdbcTemplate.query(
                    sql,
                    new CustomerOrderMapper(),
                    id
            );
        } catch (Exception e) {
            throw new Exception("Something went wrong");
        }
    }


}
