package com.littlesparkle.growler.library.user;

import com.littlesparkle.growler.library.http.BaseHttpSubscriber;
import com.littlesparkle.growler.library.http.api.Api;
import com.littlesparkle.growler.library.http.api.ApiException;

public abstract class UserSignUpSubscriber extends BaseHttpSubscriber<UserSignUpResponse> {
    @Override
    protected void onError(ApiException err) {
        onSignInFail(err);
    }

    @Override
    public void onNext(UserSignUpResponse userSignUpResponse) {
        if (userSignUpResponse.code == Api.CODE_SUCCESS) {
            onSignInSuccess(userSignUpResponse.data);
        } else {
            onSignInFail(new ApiException(userSignUpResponse.code, ""));
        }
    }

    protected abstract void onSignInSuccess(UserSignUpResponse.Data response);

    protected abstract void onSignInFail(ApiException err);
}
