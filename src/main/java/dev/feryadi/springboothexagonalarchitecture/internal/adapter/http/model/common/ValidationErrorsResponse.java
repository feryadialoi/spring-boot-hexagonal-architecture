package dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.common;

import java.util.Collection;

import br.com.fluentvalidator.context.Error;

public class ValidationErrorsResponse extends ErrorResponse<Collection<Error>> {

    public ValidationErrorsResponse(Collection<Error> errorDetails) {
        super("validationErrors", errorDetails);
    }
}
