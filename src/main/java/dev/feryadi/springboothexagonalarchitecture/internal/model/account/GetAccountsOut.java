package dev.feryadi.springboothexagonalarchitecture.internal.model.account;

import java.util.List;

public record GetAccountsOut(List<GetAccountOut> accounts) {
}
