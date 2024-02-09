package dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.controller;

import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.common.ErrorResponse;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.common.NotFoundResponse;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.common.ValidationErrorsResponse;
import dev.feryadi.springboothexagonalarchitecture.internal.exception.CustomerNotFoundException;
import dev.feryadi.springboothexagonalarchitecture.internal.exception.NotFoundException;
import dev.feryadi.springboothexagonalarchitecture.internal.exception.ValidationErrorsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorsController {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ValidationErrorsException.class)
    public ErrorResponse<?> handleValidationErrorsException(ValidationErrorsException exception) {
        return new ValidationErrorsResponse(exception.getErrors());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse<?> handleNotFoundException(NotFoundException notFoundException) {
        return new NotFoundResponse(notFoundException.getMessage());
    }

}
