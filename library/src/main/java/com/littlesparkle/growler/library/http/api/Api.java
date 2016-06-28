package com.littlesparkle.growler.library.http.api;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import retrofit2.adapter.rxjava.HttpException;

public class Api {
    public static final int DEFAULT_TIMEOUT = 15;
    public static final int CONNECT_TIMEOUT = DEFAULT_TIMEOUT;
    public static final int READ_TIMEOUT = DEFAULT_TIMEOUT;
    public static final int WRITE_TIMEOUT = DEFAULT_TIMEOUT;

    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_ERROR = 1;

    public static final int ERROR_CODE_BASE = 1000;
    public static final int ERROR_CODE_UNKNOWN = ERROR_CODE_BASE;
    public static final int ERROR_CODE_STANDARD = ERROR_CODE_BASE + 1;
    public static final int ERROR_CODE_JSON = ERROR_CODE_BASE + 2;

    public static ApiException handleError(Throwable e) {
        ApiException error;
        if (e instanceof ApiException) {
            error = (ApiException) e;
        } else if (e instanceof HttpException) {
            HttpException he = (HttpException) e;
            error = new ApiException(he.code(), he.message());
        } else if (e instanceof JsonParseException
                || e instanceof JSONException) {
            error = new ApiException(ERROR_CODE_JSON, e.getMessage());
        } else {
            error = new ApiException(ERROR_CODE_UNKNOWN, e.getMessage());
        }
        return error;
    }
}
