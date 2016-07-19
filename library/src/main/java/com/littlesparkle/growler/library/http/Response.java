package com.littlesparkle.growler.library.http;

import com.littlesparkle.growler.library.http.api.Api;

public class Response<T> {
    public int code = Api.CODE_SUCCESS;
    public T data = null;

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", data=" + data.toString() +
                '}';
    }
}
