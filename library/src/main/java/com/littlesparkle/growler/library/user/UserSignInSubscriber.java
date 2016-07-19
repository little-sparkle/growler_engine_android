package com.littlesparkle.growler.library.user;

import com.littlesparkle.growler.library.http.BaseHttpSubscriber;
import com.littlesparkle.growler.library.http.api.Api;

public abstract class UserSignInSubscriber extends BaseHttpSubscriber<UserSignInResponse> {
    @Override
    protected void onError(String message) {
        onSignInFail(message);
    }

    @Override
    public void onNext(UserSignInResponse userSignInResponse) {
        if (userSignInResponse.code == Api.CODE_SUCCESS) {
            onSignInSuccess(userSignInResponse.data);
        } else {
            onSignInFail("");
        }
    }

    protected abstract void onSignInSuccess(UserSignInResponse.Data response);

    protected abstract void onSignInFail(String message);
}
