package com.littlesparkle.growler.library.http.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.littlesparkle.growler.library.http.Response;
import com.littlesparkle.growler.library.http.api.Api;
import com.littlesparkle.growler.library.http.api.ApiException;
import com.littlesparkle.growler.library.log.Logger;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    ResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String res = value.string();
        Response response = gson.fromJson(res, Response.class);
        if (response.code != Api.CODE_SUCCESS) {
            value.close();
            throw new ApiException(res);
        }

        try {
            Logger.log("got response: " + res);
            return adapter.fromJson(res);
        } finally {
            value.close();
        }
    }
}
