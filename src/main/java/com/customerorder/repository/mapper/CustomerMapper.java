package com.customerorder.repository.mapper;

import com.customerorder.model.Customer;
import com.customerorder.model.CustomerStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println(rs.getString("customer_status"));

        return new Customer(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                CustomerStatus.valueOf(rs.getString("customer_status"))
        );
    }
}
