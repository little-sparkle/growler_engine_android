package com.littlesparkle.growler.library.order;

import android.support.annotation.NonNull;

import com.littlesparkle.growler.library.http.DefaultResponse;
import com.littlesparkle.growler.library.http.Request;
import com.littlesparkle.growler.library.order.response.OrderInfoResponse;

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
                                   int type,
                                   long timestamp) {
        return mService.requestNow(userId, token, car_type, src_latitude, src_longitude,
                dest_latitude, dest_longitude, type, timestamp)
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

    public Subscription orderRate(@NonNull Subscriber subscriber,
                                  int userId,
                                  String token,
                                  int order_id,
                                  int rate) {
        return mService.orderRate(userId, token, order_id, rate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public interface OrderApi {
        @POST("order/request/now")
        @FormUrlEncoded
        Observable<OrderInfoResponse> requestNow(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("car_type") int car_type,
                @Field("src_latitude") double src_latitude,
                @Field("src_longitude") double src_longitude,
                @Field("dest_latitude") double dest_latitude,
                @Field("dest_longitude") double dest_longitude,
                @Field("type") int type,
                @Field("timestamp") long timestamp
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

        @POST("order/rate")
        @FormUrlEncoded
        Observable<DefaultResponse> orderRate(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int order_id,
                @Field("rate") int rate
        );
    }
}
