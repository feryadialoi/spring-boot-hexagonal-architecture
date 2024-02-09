package dev.feryadi.springboothexagonalarchitecture.internal.port.usecase;

public interface UseCases {
    AccountUseCase getAccountUseCase();

    CustomerUseCase getCustomerUseCase();

    UserUseCase getUserUseCase();
}
