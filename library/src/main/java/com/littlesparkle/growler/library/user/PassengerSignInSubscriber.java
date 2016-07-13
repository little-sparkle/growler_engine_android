package com.littlesparkle.growler.library.user;

import com.littlesparkle.growler.library.http.BaseHttpSubscriber;
import com.littlesparkle.growler.library.http.Response;
import com.littlesparkle.growler.library.http.api.Api;
import com.littlesparkle.growler.library.http.api.ApiException;

public abstract class PassengerSignInSubscriber extends BaseHttpSubscriber<Response<PassengerSignInResponse>> {
    @Override
    protected void onError(ApiException err) {
        onSignInFail(err);
    }

    @Override
    public void onNext(Response<PassengerSignInResponse> passengerSignInResponseResponse) {
        if (passengerSignInResponseResponse.code == Api.CODE_SUCCESS) {
            onSignInSuccess(passengerSignInResponseResponse.data);
        } else {
            onSignInFail(new ApiException(passengerSignInResponseResponse.code, ""));
        }
    }

    protected abstract void onSignInSuccess(PassengerSignInResponse response);

    protected abstract void onSignInFail(ApiException err);
}
