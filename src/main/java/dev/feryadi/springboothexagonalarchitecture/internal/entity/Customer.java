package dev.feryadi.springboothexagonalarchitecture.internal.entity;

public record Customer(Long id, String name) {

    public Customer withId(long id) {
        return new Customer(id, this.name);
    }

}
