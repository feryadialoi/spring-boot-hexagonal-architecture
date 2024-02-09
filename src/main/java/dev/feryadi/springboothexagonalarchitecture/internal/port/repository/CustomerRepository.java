package dev.feryadi.springboothexagonalarchitecture.internal.port.repository;

import dev.feryadi.springboothexagonalarchitecture.internal.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>, Repository {
}
