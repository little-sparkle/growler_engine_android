package com.littlesparkle.growler.library.http;

import com.littlesparkle.growler.library.http.api.Api;

public class Response<T> {
    public int result = Api.RESULT_SUCCESS;
    public String message = "";
    public T data = null;

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
