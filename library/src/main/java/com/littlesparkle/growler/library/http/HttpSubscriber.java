package com.littlesparkle.growler.library.http;

import com.littlesparkle.growler.library.http.api.Api;
import com.littlesparkle.growler.library.http.api.ApiException;

import rx.Subscriber;

public abstract class HttpSubscriber<T> extends Subscriber<T> {
    public HttpSubscriber() {
    }

    @Override
    public void onCompleted() {
        if (isUnsubscribed()) {
            this.unsubscribe();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (isUnsubscribed()) {
            this.unsubscribe();
        }
        onError(Api.handleError(e));
    }

    protected abstract void onError(ApiException err);
}
