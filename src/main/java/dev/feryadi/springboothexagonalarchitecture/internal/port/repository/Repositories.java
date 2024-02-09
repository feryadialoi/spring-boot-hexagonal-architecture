package dev.feryadi.springboothexagonalarchitecture.internal.port.repository;

public interface Repositories {
    CustomerRepository getCustomerRepository();

    AccountRepository getAccountRepository();

    UserRepository getUserRepository();
}
