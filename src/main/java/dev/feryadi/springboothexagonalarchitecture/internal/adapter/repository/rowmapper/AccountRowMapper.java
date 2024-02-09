package dev.feryadi.springboothexagonalarchitecture.internal.adapter.repository.rowmapper;

import dev.feryadi.springboothexagonalarchitecture.internal.entity.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Account(rs.getLong("id"), rs.getString("name"));
    }
}
