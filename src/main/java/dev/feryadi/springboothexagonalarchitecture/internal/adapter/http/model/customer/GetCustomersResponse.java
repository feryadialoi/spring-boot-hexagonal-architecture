package dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.customer;

import java.util.List;

public record GetCustomersResponse(List<GetCustomerResponse> customers) {
}
