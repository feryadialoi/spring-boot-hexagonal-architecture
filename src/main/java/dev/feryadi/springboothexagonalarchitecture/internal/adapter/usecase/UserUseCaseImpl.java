package dev.feryadi.springboothexagonalarchitecture.internal.adapter.usecase;

import dev.feryadi.springboothexagonalarchitecture.internal.exception.UserNotFoundException;
import dev.feryadi.springboothexagonalarchitecture.internal.model.user.GetUserIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.user.GetUserOut;
import dev.feryadi.springboothexagonalarchitecture.internal.port.repository.UserRepository;
import dev.feryadi.springboothexagonalarchitecture.internal.port.usecase.UserUseCase;
import org.springframework.stereotype.Component;

@Component
public class UserUseCaseImpl extends AbstractUseCase implements UserUseCase {

    private final UserRepository userRepository;

    public UserUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GetUserOut getUser(GetUserIn in) {
        return userRepository
                .findById(in.id())
                .map(user -> new GetUserOut(user.id(), user.name()))
                .orElseThrow(UserNotFoundException::new);
    }

}
