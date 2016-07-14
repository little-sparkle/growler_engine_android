package com.littlesparkle.growler.library.update;

import com.littlesparkle.growler.library.http.BaseHttpSubscriber;
import com.littlesparkle.growler.library.http.Request;
import com.littlesparkle.growler.library.http.api.ApiException;
import com.littlesparkle.growler.library.http.converter.ConvertFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dell on 2016/7/14.
 */

public class UpdateTask extends Request<UpdateService> {


    private UpdateRequestInfo updateRequestInfo = null;

    public UpdateTask(String baseUrl) {
        super(baseUrl);

        updateRequestInfo = new UpdateRequestInfo();

    }

    @Override
    protected Class<UpdateService> getServiceClass() {
        return UpdateService.class;
    }

    public void askUpdate() {
        new UpdateTask("")
                .mService
                .otaUpdate(updateRequestInfo)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseHttpSubscriber<UpdatePackageInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    protected void onError(ApiException err) {

                    }

                    @Override
                    public void onNext(UpdatePackageInfo updatePackageInfo) {

                    }
                });
    }
}
