package dev.feryadi.springboothexagonalarchitecture.internal.adapter.usecase;

import dev.feryadi.springboothexagonalarchitecture.internal.port.usecase.AccountUseCase;
import dev.feryadi.springboothexagonalarchitecture.internal.port.usecase.CustomerUseCase;
import dev.feryadi.springboothexagonalarchitecture.internal.port.usecase.UseCases;
import dev.feryadi.springboothexagonalarchitecture.internal.port.usecase.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UseCasesImpl implements UseCases {

    private ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public CustomerUseCase getCustomerUseCase() {
        return applicationContext.getBean(CustomerUseCase.class);
    }

    @Override
    public AccountUseCase getAccountUseCase() {
        return applicationContext.getBean(AccountUseCase.class);
    }

    @Override
    public UserUseCase getUserUseCase() {
        return applicationContext.getBean(UserUseCase.class);
    }
}
