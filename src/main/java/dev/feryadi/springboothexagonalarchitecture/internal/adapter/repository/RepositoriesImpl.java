package dev.feryadi.springboothexagonalarchitecture.internal.adapter.repository;

import dev.feryadi.springboothexagonalarchitecture.internal.port.repository.AccountRepository;
import dev.feryadi.springboothexagonalarchitecture.internal.port.repository.CustomerRepository;
import dev.feryadi.springboothexagonalarchitecture.internal.port.repository.Repositories;
import dev.feryadi.springboothexagonalarchitecture.internal.port.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RepositoriesImpl implements Repositories {

    private ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public CustomerRepository getCustomerRepository() {
        return applicationContext.getBean(CustomerRepository.class);
    }

    @Override
    public AccountRepository getAccountRepository() {
        return applicationContext.getBean(AccountRepository.class);
    }

    @Override
    public UserRepository getUserRepository() {
        return applicationContext.getBean(UserRepository.class);
    }

}
