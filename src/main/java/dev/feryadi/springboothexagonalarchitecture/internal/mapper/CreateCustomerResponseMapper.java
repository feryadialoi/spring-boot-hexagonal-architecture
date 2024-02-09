package dev.feryadi.springboothexagonalarchitecture.internal.mapper;

import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.customer.CreateCustomerResponse;
import dev.feryadi.springboothexagonalarchitecture.internal.entity.Customer;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.CreateCustomerOut;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerResponseMapper implements Mapper {

    public CreateCustomerResponse map(CreateCustomerOut source) {
        return new CreateCustomerResponse(source.id(), source.name());
    }

    public CreateCustomerResponse map(Customer source) {
        return new CreateCustomerResponse(source.id(), source.name());
    }

}
