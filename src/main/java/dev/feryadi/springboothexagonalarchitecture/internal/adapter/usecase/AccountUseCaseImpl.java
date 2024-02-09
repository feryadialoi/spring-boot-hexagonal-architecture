package dev.feryadi.springboothexagonalarchitecture.internal.adapter.usecase;

import dev.feryadi.springboothexagonalarchitecture.internal.entity.Account;
import dev.feryadi.springboothexagonalarchitecture.internal.exception.AccountNotFoundException;
import dev.feryadi.springboothexagonalarchitecture.internal.model.CreateAccountIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.CreateAccountOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountsIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountsOut;
import dev.feryadi.springboothexagonalarchitecture.internal.port.repository.AccountRepository;
import dev.feryadi.springboothexagonalarchitecture.internal.port.usecase.AccountUseCase;
import org.springframework.stereotype.Component;

@Component
public class AccountUseCaseImpl extends AbstractUseCase implements AccountUseCase {

    private final AccountRepository accountRepository;

    public AccountUseCaseImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public GetAccountOut getAccount(GetAccountIn in) {
        return accountRepository
                .findById(in.id())
                .map(account -> new GetAccountOut(account.id(), account.name()))
                .orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public GetAccountsOut getAccounts(GetAccountsIn in) {
        return new GetAccountsOut(accountRepository.findAll()
                .stream()
                .map(account -> new GetAccountOut(account.id(), account.name()))
                .toList());
    }

    @Override
    public CreateAccountOut createAccount(CreateAccountIn createAccountIn) {
        Account account = accountRepository.save(new Account(null, createAccountIn.name()));
        return new CreateAccountOut(account.id(), account.name());
    }
}
