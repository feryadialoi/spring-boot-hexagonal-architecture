package dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.controller;

import br.com.fluentvalidator.context.ValidationResult;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.account.CreateAccountRequest;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.account.CreateAccountResponse;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.account.GetAccountRequest;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.account.GetAccountResponse;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.account.GetAccountsResponse;
import dev.feryadi.springboothexagonalarchitecture.internal.exception.ValidationErrorsException;
import dev.feryadi.springboothexagonalarchitecture.internal.model.CreateAccountIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.CreateAccountOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountsIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountsOut;
import dev.feryadi.springboothexagonalarchitecture.internal.port.usecase.AccountUseCase;
import dev.feryadi.springboothexagonalarchitecture.internal.validator.CreateAccountRequestValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

    private final AccountUseCase accountUseCase;

    public AccountController(AccountUseCase accountUseCase) {
        this.accountUseCase = accountUseCase;
    }

    @PostMapping
    public CreateAccountResponse createAccount(
            @RequestBody CreateAccountRequest createAccountRequest,
            CreateAccountRequestValidator createAccountRequestValidator
    ) {
        ValidationResult validationResult = createAccountRequestValidator.validate(createAccountRequest);
        if (!validationResult.isValid()) {
            throw new ValidationErrorsException(validationResult.getErrors());
        }

        CreateAccountOut createAccountOut = accountUseCase.createAccount(new CreateAccountIn(createAccountRequest.name()));
        return new CreateAccountResponse(createAccountOut.id(), createAccountOut.name());
    }

    @GetMapping("{id}")
    public GetAccountResponse getAccount(GetAccountRequest getAccountRequest) {
        GetAccountOut getAccountOut = accountUseCase.getAccount(new GetAccountIn(getAccountRequest.id()));
        return new GetAccountResponse(getAccountOut.id(), getAccountOut.name());
    }

    @GetMapping
    public GetAccountsResponse getAccounts() {
        GetAccountsOut getAccountsOut = accountUseCase.getAccounts(new GetAccountsIn());
        List<GetAccountResponse> getAccountResponseList = getAccountsOut.accounts()
                .stream()
                .map(getAccountOut -> new GetAccountResponse(getAccountOut.id(), getAccountOut.name()))
                .toList();
        return new GetAccountsResponse(getAccountResponseList);
    }

}
