package com.littlesparkle.growler.library.user;

import com.littlesparkle.growler.library.http.HttpSubscriber;
import com.littlesparkle.growler.library.http.api.Api;
import com.littlesparkle.growler.library.http.api.ApiException;
import com.littlesparkle.growler.library.http.Response;

public abstract class DriverSignInSubscriber extends HttpSubscriber<Response<DriverSignInResponse>> {
    @Override
    protected void onError(ApiException err) {
        onSignInFail(err);
    }

    @Override
    public void onNext(Response<DriverSignInResponse> driverSignInResponseResponse) {
        if (driverSignInResponseResponse.code == Api.CODE_SUCCESS) {
            onSignInSuccess(driverSignInResponseResponse.data);
        } else {
            onSignInFail(new ApiException(driverSignInResponseResponse.code, ""));
        }
    }

    protected abstract void onSignInSuccess(DriverSignInResponse response);

    protected abstract void onSignInFail(ApiException err);
}
