package com.littlesparkle.growler.library.http.api;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.littlesparkle.growler.library.http.ErrorResponse;

import org.json.JSONException;

import retrofit2.adapter.rxjava.HttpException;

public class Api {
    public static final String BASE_URL = "http://172.16.97.81/api/";

    public static final int DEFAULT_TIMEOUT = 15;
    public static final int CONNECT_TIMEOUT = DEFAULT_TIMEOUT;
    public static final int READ_TIMEOUT = DEFAULT_TIMEOUT;
    public static final int WRITE_TIMEOUT = DEFAULT_TIMEOUT;

    public static final int CODE_SUCCESS = 0;
    public static final int CODE_ERROR = 1;

    public static String handleError(Throwable e) {
        String msg;
        if (e instanceof ApiException) {
            Gson gson = new Gson();
            ErrorResponse er = gson.fromJson(((ApiException) e).message, ErrorResponse.class);
            msg = er.data.err_msg;
        } else if (e instanceof HttpException) {
            HttpException he = (HttpException) e;
            msg = he.message();
        } else {
            msg = e.getMessage();
        }
        return msg;
    }
}
