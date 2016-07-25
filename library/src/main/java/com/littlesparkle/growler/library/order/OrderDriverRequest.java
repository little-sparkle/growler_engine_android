package com.littlesparkle.growler.library.order;

import android.support.annotation.NonNull;

import com.littlesparkle.growler.library.http.DefaultResponse;
import com.littlesparkle.growler.library.http.Request;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OrderDriverRequest extends Request<OrderDriverRequest.OrderDriverApi> {
    @Override
    protected Class getServiceClass() {
        return OrderDriverApi.class;
    }

    public Subscription confirmOrder(@NonNull Subscriber subscriber,
                                     int userId,
                                     String token,
                                     int order_id,
                                     long timestamp) {
        return mService.confirmOrder(userId, token, order_id, timestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public Subscription refuseOrder(@NonNull Subscriber subscriber,
                                    int userId,
                                    String token,
                                    int order_id,
                                    long timestamp) {
        return mService.refuseOrder(userId, token, order_id, timestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public Subscription arrivedOrder(@NonNull Subscriber subscriber,
                                     int userId,
                                     String token,
                                     int order_id,
                                     long timestamp) {
        return mService.arrivedOrder(userId, token, order_id, timestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public Subscription startOrder(@NonNull Subscriber subscriber,
                                   int userId,
                                   String token,
                                   int order_id,
                                   long timestamp) {
        return mService.startOrder(userId, token, order_id, timestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public Subscription finishOrder(@NonNull Subscriber subscriber,
                                    int userId,
                                    String token,
                                    int order_id,
                                    long timestamp) {
        return mService.finishOrder(userId, token, order_id, timestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public Subscription pauseOrder(@NonNull Subscriber subscriber,
                                   int userId,
                                   String token,
                                   int order_id,
                                   long timestamp) {
        return mService.pauseOrder(userId, token, order_id, timestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public Subscription restartOrder(@NonNull Subscriber subscriber,
                                     int userId,
                                     String token,
                                     int order_id,
                                     long timestamp) {
        return mService.restartOrder(userId, token, order_id, timestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public Subscription cancelOrder(@NonNull Subscriber subscriber,
                                    int userId,
                                    String token,
                                    int order_id,
                                    long timestamp,
                                    int reason_code,
                                    String reason_description) {
        return mService.cancelOrder(userId, token, order_id, timestamp, reason_code, reason_description)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public interface OrderDriverApi {
        @POST("order/driver/confirm")
        @FormUrlEncoded
        Observable<DefaultResponse> confirmOrder(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("timestamp") long timestamp
        );

        @POST("order/driver/refuse")
        @FormUrlEncoded
        Observable<DefaultResponse> refuseOrder(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("timestamp") long timestamp
        );

        @POST("order/driver/arrived")
        @FormUrlEncoded
        Observable<DefaultResponse> arrivedOrder(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("timestamp") long timestamp
        );

        @POST("order/driver/start")
        @FormUrlEncoded
        Observable<DefaultResponse> startOrder(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("timestamp") long timestamp
        );

        @POST("order/driver/finish")
        @FormUrlEncoded
        Observable<DefaultResponse> finishOrder(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("timestamp") long timestamp
        );

        @POST("order/driver/pause")
        @FormUrlEncoded
        Observable<DefaultResponse> pauseOrder(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("timestamp") long timestamp
        );

        @POST("order/driver/restart")
        @FormUrlEncoded
        Observable<DefaultResponse> restartOrder(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("timestamp") long timestamp
        );

        @POST("order/driver/cancel")
        @FormUrlEncoded
        Observable<DefaultResponse> cancelOrder(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("timestamp") long timestamp,
                @Field("reason_code") int reason_code,
                @Field("reason_description") String reason_description
        );
    }
}
