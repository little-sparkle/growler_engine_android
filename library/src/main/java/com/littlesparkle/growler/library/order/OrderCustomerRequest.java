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

public class OrderCustomerRequest extends Request<OrderCustomerRequest.OrderCustomerApi> {
    @Override
    protected Class getServiceClass() {
        return OrderCustomerApi.class;
    }

    public Subscription cancelOrder(@NonNull Subscriber<DefaultResponse> subscriber,
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

    public interface OrderCustomerApi {
        @POST("order/customer/cancel")
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
