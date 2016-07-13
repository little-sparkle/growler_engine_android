package com.littlesparkle.growler.library.user;

import com.littlesparkle.growler.library.http.BaseHttpSubscriber;
import com.littlesparkle.growler.library.http.api.Api;
import com.littlesparkle.growler.library.http.api.ApiException;
import com.littlesparkle.growler.library.http.DefaultResponse;

public abstract class SignOutSubscriber extends BaseHttpSubscriber<DefaultResponse> {
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
