package dev.feryadi.springboothexagonalarchitecture.internal.exception;

import br.com.fluentvalidator.context.Error;

import java.util.Collection;

public class ValidationErrorsException extends RuntimeException {
    private final Collection<Error> errors;

    public ValidationErrorsException(Collection<Error> errors) {
        this.errors = errors;
    }

    public Collection<Error> getErrors() {
        return errors;
    }
}
