package dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.common;

public class ErrorResponse<T> {

    private String errorType;
    private T errorDetails;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorType, T errorDetails) {
        this.errorType = errorType;
        this.errorDetails = errorDetails;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public T getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(T errorDetails) {
        this.errorDetails = errorDetails;
    }

}
