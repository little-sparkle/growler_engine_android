package com.littlesparkle.growler.library.user.driver;


import com.littlesparkle.growler.library.http.DefaultResponse;
import com.littlesparkle.growler.library.http.Request;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public class DriverRequest extends Request<DriverRequest.DriverApi> {

    @Override
    protected Class<DriverApi> getServiceClass() {
        return DriverApi.class;
    }

    public interface DriverApi {
        @GET("driver/info")
        Observable<DriverInfoResponse> getInfo(
                @Field("user_id") int userId,
                @Field("token") String token
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
