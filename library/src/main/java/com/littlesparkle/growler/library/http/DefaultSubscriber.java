package com.littlesparkle.growler.library.http;

import com.littlesparkle.growler.library.http.api.Api;
import com.littlesparkle.growler.library.http.api.ApiException;

public class DefaultSubscriber extends BaseHttpSubscriber<DefaultResponse> {
    public DefaultSubscriber() {
        super();
    }

    @Override
    protected void onError(ApiException err) {
        onFail(err);
    }

    @Override
    public void onNext(DefaultResponse response) {
        if (response.code == Api.CODE_SUCCESS) {
            onSuccess();
        } else {
            onFail(new ApiException(response.code, ""));
        }
    }

    protected void onSuccess() {
    }

    protected void onFail(ApiException err) {
    }
}
