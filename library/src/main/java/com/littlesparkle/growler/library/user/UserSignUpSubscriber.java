package com.littlesparkle.growler.library.user;

import com.littlesparkle.growler.library.http.BaseHttpSubscriber;
import com.littlesparkle.growler.library.http.api.Api;

public abstract class UserSignUpSubscriber extends BaseHttpSubscriber<UserSignUpResponse> {
    @Override
    protected void onError(String message) {
        onSignInFail(message);
    }

    @Override
    public void onNext(UserSignUpResponse userSignUpResponse) {
        if (userSignUpResponse.code == Api.CODE_SUCCESS) {
            onSignInSuccess(userSignUpResponse.data);
        } else {
            onSignInFail("");
        }
    }

    protected abstract void onSignInSuccess(UserSignUpResponse.Data response);

    protected abstract void onSignInFail(String message);
}
