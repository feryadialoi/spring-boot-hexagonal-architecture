package dev.feryadi.springboothexagonalarchitecture.internal.port.repository;

import dev.feryadi.springboothexagonalarchitecture.internal.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long>, Repository {
}
