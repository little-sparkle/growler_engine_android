package com.littlesparkle.growler.library.http;

import com.littlesparkle.growler.library.http.api.Api;
import com.littlesparkle.growler.library.http.api.ApiException;

public class DefaultSubscriber extends BaseHttpSubscriber<DefaultResponse> {
    public DefaultSubscriber() {
        super();
    }

    @Override
    protected void onError(String message) {
        onFail(message);
    }

    @Override
    public void onNext(DefaultResponse response) {
        if (response.code == Api.CODE_SUCCESS) {
            onSuccess();
        } else {
            onFail("");
        }
    }

    protected void onSuccess() {
    }

    protected void onFail(String message) {
    }
}
