package dev.feryadi.springboothexagonalarchitecture.internal.port.repository;

import dev.feryadi.springboothexagonalarchitecture.internal.entity.User;

public interface UserRepository extends CrudRepository<User, Long>, Repository {
}
