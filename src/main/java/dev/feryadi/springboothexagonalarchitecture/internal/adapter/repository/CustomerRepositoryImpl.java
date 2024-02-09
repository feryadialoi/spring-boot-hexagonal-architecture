package dev.feryadi.springboothexagonalarchitecture.internal.adapter.repository;

import dev.feryadi.springboothexagonalarchitecture.internal.adapter.repository.rowmapper.CustomerRowMapper;
import dev.feryadi.springboothexagonalarchitecture.internal.entity.Customer;
import dev.feryadi.springboothexagonalarchitecture.internal.port.repository.CustomerRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerRepositoryImpl extends RepositoryImpl implements CustomerRepository {

    private final JdbcClient jdbcClient;

    public CustomerRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Customer save(Customer entity) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcClient.sql("INSERT INTO customers (name) VALUES (?)")
                .param(1, entity.name())
                .update(generatedKeyHolder);

        return entity.withId(generatedKeyHolder.getKey().longValue());
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jdbcClient.sql("SELECT id, name FROM customers WHERE id = ? LIMIT 1")
                .param(1, id)
                .query(new CustomerRowMapper())
                .optional();
    }

    @Override
    public List<Customer> findAll() {
        return jdbcClient.sql("SELECT id, name FROM customers")
                .query(new CustomerRowMapper())
                .list();
    }
}
