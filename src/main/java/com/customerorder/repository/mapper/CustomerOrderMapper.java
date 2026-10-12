package com.customerorder.repository.mapper;

import com.customerorder.model.CustomerOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerOrderMapper implements RowMapper<CustomerOrder> {

    @Override
    public CustomerOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerOrder(
                rs.getLong("id"),
                rs.getLong("customer_id"),
                rs.getString("item_name"),
                rs.getDouble("price")
        );
    }
}
