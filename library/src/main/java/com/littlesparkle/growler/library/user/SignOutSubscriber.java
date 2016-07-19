package com.littlesparkle.growler.library.user;

import com.littlesparkle.growler.library.http.BaseHttpSubscriber;
import com.littlesparkle.growler.library.http.DefaultResponse;
import com.littlesparkle.growler.library.http.api.Api;

public abstract class SignOutSubscriber extends BaseHttpSubscriber<DefaultResponse> {
    @Override
    protected void onError(String message) {
        onSignOutFail(message);
    }

    @Override
    public void onNext(DefaultResponse response) {
        if (response.code == Api.CODE_SUCCESS) {
            onSignOutSuccess();
        } else {
            onSignOutFail("");
        }
    }

    protected abstract void onSignOutSuccess();

    protected abstract void onSignOutFail(String message);
}
