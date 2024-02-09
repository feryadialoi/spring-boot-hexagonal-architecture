package dev.feryadi.springboothexagonalarchitecture.internal.port.usecase;

import dev.feryadi.springboothexagonalarchitecture.internal.model.user.GetUserIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.user.GetUserOut;

public interface UserUseCase extends UseCase {
    GetUserOut getUser(GetUserIn in);
}
