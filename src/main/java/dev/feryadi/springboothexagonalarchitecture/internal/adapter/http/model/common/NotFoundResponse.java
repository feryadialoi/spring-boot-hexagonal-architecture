package dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.common;

public class NotFoundResponse extends ErrorResponse<String> {
    public NotFoundResponse(String errorDetails) {
        super("notFound", errorDetails);
    }
}
