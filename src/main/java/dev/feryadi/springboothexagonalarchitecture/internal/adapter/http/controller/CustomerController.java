package dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.controller;

import br.com.fluentvalidator.context.ValidationResult;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.customer.CreateCustomerRequest;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.customer.CreateCustomerResponse;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.customer.GetCustomerRequest;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.customer.GetCustomerResponse;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.customer.GetCustomersResponse;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.customer.UpdateCustomerRequest;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.customer.UpdateCustomerResponse;
import dev.feryadi.springboothexagonalarchitecture.internal.exception.ValidationErrorsException;
import dev.feryadi.springboothexagonalarchitecture.internal.mapper.CreateCustomerResponseMapper;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.CreateCustomerIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.CreateCustomerOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.GetCustomerIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.GetCustomerOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.customer.GetCustomersOut;
import dev.feryadi.springboothexagonalarchitecture.internal.port.usecase.CustomerUseCase;
import dev.feryadi.springboothexagonalarchitecture.internal.validator.CreateCustomerRequestValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    public CustomerController(CustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }

    @PostMapping
    public CreateCustomerResponse createCustomer(
            @RequestBody CreateCustomerRequest createCustomerRequest,
            CreateCustomerRequestValidator createCustomerRequestValidator,
            CreateCustomerResponseMapper createCustomerResponseMapper) {
        ValidationResult validationResult = createCustomerRequestValidator.validate(createCustomerRequest);
        if (!validationResult.isValid()) {
            throw new ValidationErrorsException(validationResult.getErrors());
        }

        CreateCustomerIn createCustomerIn = new CreateCustomerIn(createCustomerRequest.name());
        CreateCustomerOut createCustomerOut = customerUseCase.createCustomer(createCustomerIn);
        return createCustomerResponseMapper.map(createCustomerOut);
    }

    @GetMapping("{id}")
    public GetCustomerResponse getCustomer(GetCustomerRequest getCustomerRequest) {
        GetCustomerOut getCustomerOut = customerUseCase.getCustomer(new GetCustomerIn(getCustomerRequest.id()));
        return new GetCustomerResponse(getCustomerOut.id(), getCustomerOut.name());
    }

    @GetMapping
    public GetCustomersResponse getCustomers() {
        GetCustomersOut getCustomersOut = customerUseCase.getCustomers();
        List<GetCustomerResponse> getCustomerResponseList = getCustomersOut.customers()
                .stream()
                .map(getCustomerOut -> new GetCustomerResponse(getCustomerOut.id(), getCustomerOut.name()))
                .toList();
        return new GetCustomersResponse(getCustomerResponseList);
    }

    @PutMapping
    public UpdateCustomerResponse updateCustomer(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return null;
    }

}
