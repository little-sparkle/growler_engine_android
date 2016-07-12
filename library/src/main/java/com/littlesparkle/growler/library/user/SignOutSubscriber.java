package com.littlesparkle.growler.library.user;

import com.littlesparkle.growler.library.http.HttpSubscriber;
import com.littlesparkle.growler.library.http.Response;
import com.littlesparkle.growler.library.http.api.Api;
import com.littlesparkle.growler.library.http.api.ApiException;
import com.littlesparkle.growler.library.http.api.DefaultResponse;

public abstract class SignOutSubscriber extends HttpSubscriber<DefaultResponse> {
    @Override
    protected void onError(ApiException err) {
        onSignOutFail(err);
    }

    @Override
    public void onNext(DefaultResponse response) {
        if (response.code == Api.CODE_SUCCESS) {
            onSignOutSuccess();
        } else {
            onSignOutFail(new ApiException(response.code, ""));
        }
    }

    protected abstract void onSignOutSuccess();

    protected abstract void onSignOutFail(ApiException err);
}
