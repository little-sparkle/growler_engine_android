package com.littlesparkle.growler.library.user.driver;


import com.littlesparkle.growler.library.http.DefaultResponse;
import com.littlesparkle.growler.library.http.Request;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DriverRequest extends Request<DriverRequest.DriverApi> {

    @Override
    protected Class<DriverApi> getServiceClass() {
        return DriverApi.class;
    }

    public Subscription getDriverInfo(Subscriber<DriverInfoResponse> subscriber,
                                      int userId, int driverId, String token) {
        return mService.getInfo(userId, driverId, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public interface DriverApi {
        @GET("driver/info")
        Observable<DriverInfoResponse> getInfo(
                @Query("user_id") int userId,
                @Query("driver_id") int driverId,
                @Query("token") String token
        );

        @POST("driver/online")
        @FormUrlEncoded
        Observable<DefaultResponse> online(
                @Field("user_id") int userId,
                @Field("token") String token
        );

        @POST("driver/offline")
        @FormUrlEncoded
        Observable<DefaultResponse> offline(
                @Field("user_id") int userId,
                @Field("token") String token
        );

        @POST("driver/rate")
        @FormUrlEncoded
        Observable<DefaultResponse> rate(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int orderId,
                @Field("rate") int rate
        );
    }
}
