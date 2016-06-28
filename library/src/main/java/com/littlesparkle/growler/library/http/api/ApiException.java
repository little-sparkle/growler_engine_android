package com.littlesparkle.growler.library.http.api;

public class ApiException extends RuntimeException {
    public int code;
    public String message;

    public ApiException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
