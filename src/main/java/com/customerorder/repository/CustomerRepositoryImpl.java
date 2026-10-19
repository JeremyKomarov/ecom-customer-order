package com.customerorder.repository;

import com.customerorder.model.Customer;
import com.customerorder.model.CustomerStatus;
import com.customerorder.redis.CacheRepository;
import com.customerorder.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String CUSTOMER_TABLE_NAME = "customer";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    CacheRepository cacheRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Long createCustomer(Customer customer) throws Exception {
        String sql = "INSERT INTO " + CUSTOMER_TABLE_NAME +
                     " (first_name, last_name, email, customer_status) VALUES (?, ?, ?, ?)";

        try {
            jdbcTemplate.update(
                    sql,
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getEmail(),
                    customer.getCustomerStatus().name()
            );

            return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
        } catch (Exception e) {
            throw new Exception("Something went wrong");
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception {
        String sql = "UPDATE " + CUSTOMER_TABLE_NAME +
                     " SET first_name = ?, last_name = ?, email = ?, customer_status = ?" +
                     " WHERE id = ?";
        try {
            jdbcTemplate.update(
                    sql,
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getEmail(),
                    customer.getCustomerStatus().name(),
                    customer.getId()
            );

            String customerAsString = objectMapper.writeValueAsString(customer);
            cacheRepository.updateCacheEntity(customer.getId().toString(), customerAsString);
        } catch (Exception e) {
            throw new Exception("Something went wrong");
        }
    }

    @Override
    public void deleteCustomerById(Long id) throws Exception {
        String sql = "DELETE FROM " + CUSTOMER_TABLE_NAME +
                     " WHERE id = ?";

        try {
            jdbcTemplate.update(
                    sql,
                    id
            );

            cacheRepository.deleteCacheEntity(id.toString());
        } catch (Exception e) {
            throw new Exception("Something went wrong", e);
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        String customerFromCacheAsString = cacheRepository.getCacheEntity(id.toString());

        if (customerFromCacheAsString == null) {
            String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME +
                         " WHERE id = ?";

            try {
                Customer customerFromDB = jdbcTemplate.queryForObject(
                        sql,
                        new CustomerMapper(),
                        id
                );

                String customerAsString = objectMapper.writeValueAsString(customerFromDB);
                cacheRepository.createCacheEntity(customerFromDB.getId().toString(), customerAsString);
                return customerFromDB;
            } catch (EmptyResultDataAccessException e) {
                return null;
            }
        } else {
            Customer customerFromCachesAsObject = objectMapper.readValue(customerFromCacheAsString, Customer.class);
            return customerFromCachesAsObject;
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

    @Override
    public List<Long> getAllCustomerIdsByFirstName(String firstName) {
        String sql = "SELECT id FROM " + CUSTOMER_TABLE_NAME +
                     " WHERE first_name = ?";
        try {
            return jdbcTemplate.queryForList(
                    sql,
                    Long.class,
                    firstName
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomersByStatus(CustomerStatus customerStatus) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME +
                     " WHERE customer_status = ?";

        try {
            return jdbcTemplate.query(
                    sql,
                    new CustomerMapper(),
                    customerStatus.name()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
