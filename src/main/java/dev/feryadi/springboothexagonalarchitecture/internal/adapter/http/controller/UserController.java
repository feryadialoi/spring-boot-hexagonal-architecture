package dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.controller;

import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.user.GetUserRequest;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.user.GetUserResponse;
import dev.feryadi.springboothexagonalarchitecture.internal.model.user.GetUserIn;
import dev.feryadi.springboothexagonalarchitecture.internal.model.user.GetUserOut;
import dev.feryadi.springboothexagonalarchitecture.internal.port.usecase.UserUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @GetMapping("{id}")
    public GetUserResponse getUser(GetUserRequest getUserRequest) {
        GetUserOut getUserOut = userUseCase.getUser(new GetUserIn(getUserRequest.id()));
        return new GetUserResponse(getUserOut.id(), getUserOut.name());
    }
}
