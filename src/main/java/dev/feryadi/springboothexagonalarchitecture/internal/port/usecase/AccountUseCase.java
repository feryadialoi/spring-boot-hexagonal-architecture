package dev.feryadi.springboothexagonalarchitecture.internal.port.usecase;

import dev.feryadi.springboothexagonalarchitecture.internal.model.CreateAccountIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.CreateAccountOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountOut;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountsIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.account.GetAccountsOut;

public interface AccountUseCase extends UseCase {
    GetAccountOut getAccount(GetAccountIn in);

    GetAccountsOut getAccounts(GetAccountsIn in);

    CreateAccountOut createAccount(CreateAccountIn createAccountIn);
}
