package dev.feryadi.springboothexagonalarchitecture.internal.adapter.repository;

import dev.feryadi.springboothexagonalarchitecture.internal.adapter.repository.rowmapper.UserRowMapper;
import dev.feryadi.springboothexagonalarchitecture.internal.entity.User;
import dev.feryadi.springboothexagonalarchitecture.internal.port.repository.UserRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryImpl extends RepositoryImpl implements UserRepository {

    private final JdbcClient jdbcClient;

    public UserRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public User save(User entity) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcClient.sql("INSERT INTO users (name) VALUES (?)")
                .param(1, entity.name())
                .update(generatedKeyHolder);

        return entity.withId(generatedKeyHolder.getKey().longValue());
    }

    @Override
    public Optional<User> findById(Long id) {
        return jdbcClient.sql("SELECT id, name FROM users WHERE id = ? LIMIT 1")
                .param(1, id)
                .query(new UserRowMapper())
                .optional();
    }

    @Override
    public List<User> findAll() {
        return jdbcClient.sql("SELECT id, name FROM users")
                .query(new UserRowMapper())
                .list();
    }
}
