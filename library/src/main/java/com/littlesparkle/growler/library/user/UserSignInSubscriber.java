package com.littlesparkle.growler.library.user;

import com.littlesparkle.growler.library.http.BaseHttpSubscriber;
import com.littlesparkle.growler.library.http.Response;
import com.littlesparkle.growler.library.http.api.Api;
import com.littlesparkle.growler.library.http.api.ApiException;

public abstract class UserSignInSubscriber extends BaseHttpSubscriber<UserSignInResponse> {
    @Override
    protected void onError(ApiException err) {
        onSignInFail(err);
    }

    @Override
    public void onNext(UserSignInResponse userSignInResponse) {
        if (userSignInResponse.code == Api.CODE_SUCCESS) {
            onSignInSuccess(userSignInResponse.data);
        } else {
            onSignInFail(new ApiException(userSignInResponse.code, ""));
        }
    }

    protected abstract void onSignInSuccess(UserSignInResponse.Data response);

    protected abstract void onSignInFail(ApiException err);
}
