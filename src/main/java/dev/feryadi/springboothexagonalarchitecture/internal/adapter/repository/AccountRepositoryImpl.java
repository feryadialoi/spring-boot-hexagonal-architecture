package dev.feryadi.springboothexagonalarchitecture.internal.adapter.repository;

import dev.feryadi.springboothexagonalarchitecture.internal.adapter.repository.rowmapper.AccountRowMapper;
import dev.feryadi.springboothexagonalarchitecture.internal.entity.Account;
import dev.feryadi.springboothexagonalarchitecture.internal.port.repository.AccountRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountRepositoryImpl extends RepositoryImpl implements AccountRepository {

    private final JdbcClient jdbcClient;

    public AccountRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Account save(Account entity) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcClient.sql("INSERT INTO accounts (name) VALUES (?)")
                .param(1, entity.name())
                .update(generatedKeyHolder);

        return entity.withId(generatedKeyHolder.getKey().longValue());
    }

    @Override
    public Optional<Account> findById(Long id) {
        return jdbcClient.sql("SELECT id, name FROM accounts WHERE id = ? LIMIT 1")
                .param(1, id)
                .query(new AccountRowMapper())
                .optional();
    }

    @Override
    public List<Account> findAll() {
        return jdbcClient.sql("SELECT id, name FROM accounts")
                .query(new AccountRowMapper())
                .list();
    }
}
