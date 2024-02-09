package dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.account;

import java.util.List;

public record GetAccountsResponse(List<GetAccountResponse> accounts) {
}
