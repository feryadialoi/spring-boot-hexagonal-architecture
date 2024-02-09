package dev.feryadi.springboothexagonalarchitecture.internal.entity;

public record Account(Long id, String name) {

    public Account withId(Long id) {
        return new Account(id, this.name);
    }

}
