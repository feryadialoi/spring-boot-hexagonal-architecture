package dev.feryadi.springboothexagonalarchitecture.internal.model.customer;

import java.util.List;

public record GetCustomersOut(List<GetCustomerOut> customers) {
}
