package dev.feryadi.springboothexagonalarchitecture.internal.adapter.repository.rowmapper;

import dev.feryadi.springboothexagonalarchitecture.internal.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
