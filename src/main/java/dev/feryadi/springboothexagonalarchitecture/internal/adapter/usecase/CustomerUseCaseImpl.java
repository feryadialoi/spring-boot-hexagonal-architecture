package dev.feryadi.springboothexagonalarchitecture.internal.adapter.usecase;

import dev.feryadi.springboothexagonalarchitecture.internal.exception.CustomerNotFoundException;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountsIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountsOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.CreateCustomerIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.CreateCustomerOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.GetCustomerIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.GetCustomerOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.GetCustomersOut;
import dev.feryadi.springboothexagonalarchitecture.internal.port.repository.CustomerRepository;
import dev.feryadi.springboothexagonalarchitecture.internal.port.usecase.CustomerUseCase;
import org.springframework.stereotype.Component;

@Component
public class CustomerUseCaseImpl extends AbstractUseCase implements CustomerUseCase {

    private final CustomerRepository customerRepository;

    public CustomerUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public GetCustomerOut getCustomer(GetCustomerIn in) {
        return customerRepository
                .findById(in.id())
                .map(customer -> new GetCustomerOut(customer.id(), customer.name()))
                .orElseThrow(CustomerNotFoundException::new);
    }

    @Override
    public CreateCustomerOut createCustomer(CreateCustomerIn createCustomerIn) {
        return null;
    }

    @Override
    public GetCustomersOut getCustomers() {
        return new GetCustomersOut(customerRepository.findAll()
                .stream()
                .map(customer -> new GetCustomerOut(customer.id(), customer.name()))
                .toList());
    }

    public void getAccounts() {
        GetAccountsOut getAccountsOut = getUseCases()
                .getAccountUseCase()
                .getAccounts(new GetAccountsIn());
    }

}
