package com.littlesparkle.growler.library.http;

import com.littlesparkle.growler.library.http.api.Api;
import com.littlesparkle.growler.library.log.Logger;

import rx.Subscriber;

public abstract class BaseHttpSubscriber<T> extends Subscriber<T> {
    private IProgress mProgress;
    private IToast mToast;

    public BaseHttpSubscriber() {
        this(null, null);
    }

    public BaseHttpSubscriber(IProgress progress, IToast toast) {
        mProgress = progress;
        mToast = toast;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mProgress != null) {
            mProgress.showProgress();
        }
    }

    @Override
    public void onCompleted() {
        if (isUnsubscribed()) {
            this.unsubscribe();
        }
        if (mProgress != null) {
            mProgress.dismissProgress();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (isUnsubscribed()) {
            this.unsubscribe();
        }
        if (mProgress != null) {
            mProgress.dismissProgress();
        }
        onError(Api.handleError(e));
    }

    protected void onError(ErrorResponse error) {
        if (mToast != null) {
            mToast.showToast(error.data.err_msg);
        }
        Logger.e("Got error message:" + error);
    }

    public interface IProgress {
        void showProgress();

        void dismissProgress();
    }

    public interface IToast {
        void showToast(String msg);

        void dismissToast();
    }
}
