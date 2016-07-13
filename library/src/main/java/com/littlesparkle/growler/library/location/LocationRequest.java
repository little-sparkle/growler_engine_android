package com.littlesparkle.growler.library.location;

import android.support.annotation.NonNull;

import com.littlesparkle.growler.library.http.Request;
import com.littlesparkle.growler.library.http.Response;
import com.littlesparkle.growler.library.http.DefaultResponse;
import com.littlesparkle.growler.library.http.DefaultSubscriber;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Subscriber;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class LocationRequest extends Request<LocationRequest.LocationApi> {

    @Override
    protected Class getServiceClass() {
        return LocationRequest.LocationApi.class;
    }

    public Subscription reportLocation(
            int userId, @NonNull String token, double lat, double lng) {
        return reportLocation(new DefaultSubscriber(), userId, token, lat, lng);
    }

    public Subscription reportLocation(@NonNull Subscriber subscriber,
                                       int userId, @NonNull String token, double lat, double lng) {
        return mService.report(userId, token, lat, lng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public interface LocationApi {
        @POST("location/report")
        @FormUrlEncoded
        Observable<Response<DefaultResponse>> report(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("lat") double lat,
                @Field("lng") double lng
        );
    }
}


