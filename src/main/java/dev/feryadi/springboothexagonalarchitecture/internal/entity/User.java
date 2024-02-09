package dev.feryadi.springboothexagonalarchitecture.internal.entity;

public record User(Long id, String name) {

    public User withId(long id) {
        return new User(id, this.name);
    }

}
