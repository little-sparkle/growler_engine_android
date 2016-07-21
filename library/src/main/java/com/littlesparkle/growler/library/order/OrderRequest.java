package com.littlesparkle.growler.library.order;

import android.support.annotation.NonNull;

import com.littlesparkle.growler.library.http.DefaultResponse;
import com.littlesparkle.growler.library.http.Request;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class OrderRequest extends Request<OrderRequest.OrderApi> {

    @Override
    protected Class getServiceClass() {
        return OrderApi.class;
    }

    public Subscription requestNow(@NonNull Subscriber subscriber,
                                   int userId,
                                   String token,
                                   int car_type,
                                   double src_latitude,
                                   double src_longitude,
                                   double dest_latitude,
                                   double dest_longitude,
                                   long timestamp) {
        return mService.requestNow(userId, token, car_type, src_latitude, src_longitude, dest_latitude, dest_longitude, timestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

//    public Subscription requestReservation(@NonNull Subscriber subscriber,
//                                           int userId,
//                                           String token,
//                                           int car_type,
//                                           double src_latitude,
//                                           double src_longitude,
//                                           double dest_latitude,
//                                           double dest_longitude,
//                                           long timestamp) {
//        return mService.requestReservation(userId, token, car_type, src_latitude, src_longitude, dest_latitude, dest_longitude, timestamp)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .unsubscribeOn(Schedulers.io())
//                .subscribe(subscriber);
//    }

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

    public Subscription getOrderInfo(@NonNull Subscriber subscriber,
                                     int userId,
                                     String token,
                                     int order_id) {
        return mService.orderInfo(userId, token, order_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public Subscription getOrderHistory(@NonNull Subscriber subscriber,
                                        int userId,
                                        String token,
                                        int last_index,
                                        int page_count) {
        return mService.orderHistory(userId, token, last_index, page_count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public interface OrderApi {
        @POST("order/request/now")
        @FormUrlEncoded
        Observable<RequestOrderResponse> requestNow(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("car_type") int car_type,
                @Field("src_latitude") double src_latitude,
                @Field("src_longitude") double src_longitude,
                @Field("dest_latitude") double dest_latitude,
                @Field("dest_longitude") double dest_longitude,
                @Field("timestamp") long timestamp
        );

//        @POST("order/request/reservation")
//        @FormUrlEncoded
//        Observable<RequestOrderResponse> requestReservation(
//                @Field("user_id") int userId,
//                @Field("token") String token,
//                @Field("car_type") int car_type,
//                @Field("src_latitude") double src_latitude,
//                @Field("src_longitude") double src_longitude,
//                @Field("dest_latitude") double dest_latitude,
//                @Field("dest_longitude") double dest_longitude,
//                @Field("timestamp") long timestamp
//        );

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

        @POST("order/start")
        @FormUrlEncoded
        Observable<DefaultResponse> startOrder(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("timestamp") long timestamp
        );

        @POST("order/finish")
        @FormUrlEncoded
        Observable<DefaultResponse> finishOrder(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("timestamp") long timestamp
        );

        @POST("order/pause")
        @FormUrlEncoded
        Observable<DefaultResponse> pauseOrder(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("timestamp") long timestamp
        );

        @POST("order/cancel")
        @FormUrlEncoded
        Observable<DefaultResponse> cancelOrder(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("timestamp") long timestamp,
                @Field("reason_code") int reason_code,
                @Field("reason_description") String reason_description
        );

        @GET("order/info")
        Observable<DefaultResponse> orderInfo(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id
        );

        @GET("order/history")
        Observable<DefaultResponse> orderHistory(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("last_index") int last_index,
                @Field("page_count") int page_count
        );
    }
}


