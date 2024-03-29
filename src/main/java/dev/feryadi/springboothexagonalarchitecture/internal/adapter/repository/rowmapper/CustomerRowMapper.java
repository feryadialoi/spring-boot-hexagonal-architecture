package dev.feryadi.springboothexagonalarchitecture.internal.adapter.repository.rowmapper;

import dev.feryadi.springboothexagonalarchitecture.internal.entity.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(rs.getLong("id"),rs.getString("name"));
    }
}
