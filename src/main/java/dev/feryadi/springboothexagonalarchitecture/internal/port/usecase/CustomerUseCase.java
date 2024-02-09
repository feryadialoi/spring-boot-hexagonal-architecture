package dev.feryadi.springboothexagonalarchitecture.internal.port.usecase;

import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.CreateCustomerIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.CreateCustomerOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.GetCustomerIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.GetCustomerOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.GetCustomersOut;

public interface CustomerUseCase extends UseCase {
    GetCustomerOut getCustomer(GetCustomerIn in);

    CreateCustomerOut createCustomer(CreateCustomerIn createCustomerIn);

    GetCustomersOut getCustomers();
}
