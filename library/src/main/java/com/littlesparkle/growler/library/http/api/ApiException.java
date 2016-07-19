package com.littlesparkle.growler.library.http.api;

public class ApiException extends RuntimeException {
    public String message;

    public ApiException() {
    }

    public ApiException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "message='" + message + '\'' +
                '}';
    }
}
