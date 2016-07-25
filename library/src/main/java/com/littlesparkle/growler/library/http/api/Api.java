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

    public static ErrorResponse handleError(Throwable e) {
        ErrorResponse res;
        if (e instanceof ApiException) {
            Gson gson = new Gson();
            res = gson.fromJson(((ApiException) e).message, ErrorResponse.class);
        } else if (e instanceof HttpException) {
            HttpException he = (HttpException) e;
            res = new ErrorResponse();
            res.data.err_msg = he.message();
            res.data.err_no = String.valueOf(he.code());
        } else {
            res = new ErrorResponse();
            res.data.err_msg = e.getMessage();
            res.data.err_no = e.getLocalizedMessage();
        }
        return res;
    }

    public static final String USER_TOKEN_ERROR = "user_token_error";
    public static final String[] ERRPR_NEED_SIGN_IN = {
            USER_TOKEN_ERROR
    };

    public static final boolean needReSignIn(String error) {
        for (String str : ERRPR_NEED_SIGN_IN) {
            if (str.equals(error)) {
                return true;
            }
        }
        return false;
    }
}
