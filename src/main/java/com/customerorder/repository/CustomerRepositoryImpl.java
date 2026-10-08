package com.customerorder.repository;

import com.customerorder.model.Customer;
import com.customerorder.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String CUSTOMER_TABLE_NAME = "customer";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createCustomer(Customer customer) {
        String sql = "INSERT INTO " + CUSTOMER_TABLE_NAME +
                     " (first_name, last_name, email) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql = "UPDATE " + CUSTOMER_TABLE_NAME +
                     " SET first_name = ?, last_name = ?, email = ?" +
                     " WHERE id = ?";

        jdbcTemplate.update(
                sql,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getId()
        );
    }

    @Override
    public void deleteCustomerById(Long id) {
        String sql = "DELETE FROM " + CUSTOMER_TABLE_NAME +
                     " WHERE id = ?";

        jdbcTemplate.update(
                sql,
                id
        );
    }

    @Override
    public Customer getCustomerById(Long id) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME +
                     " WHERE id = ?";

        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    new CustomerMapper(),
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME;

        try {
            return jdbcTemplate.query(
                    sql,
                    new CustomerMapper()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
