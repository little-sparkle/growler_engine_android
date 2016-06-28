package com.littlesparkle.growler.library.update;

import android.support.annotation.NonNull;

import com.littlesparkle.growler.library.http.Request;

import retrofit2.http.GET;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class UpdateRequest extends Request<UpdateRequest.Service> {

    public UpdateRequest(@NonNull String url) {
        super(url);
    }

    @Override
    protected Class getServiceClass() {
        return UpdateRequest.Service.class;
    }

    public Subscription update(@NonNull Subscriber<UpdateResponse> subscriber,
                               String packageName, String version) {
        return mService.checkUpdate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public interface Service {
        @GET()
        Observable<UpdateResponse> checkUpdate();
    }
}


