package com.littlesparkle.growler.library.user.driver;


import com.littlesparkle.growler.library.http.DefaultResponse;
import com.littlesparkle.growler.library.http.Request;
import com.littlesparkle.growler.library.user.UserSignUpResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    public Subscription signup(Subscriber<DriverSignUpResponse> subscriber,
                               String mobile, String password, String auth_code) {
        return mService.signup(mobile, password, auth_code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public interface DriverApi {
        @GET("driver/info")
        Observable<DriverSignInResponse> getInfo(
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

        @POST("user/signup")
        @FormUrlEncoded
        Observable<DriverSignUpResponse> signup(
                @Field("mobile") String mobile,
                @Field("password") String password,
                @Field("auth_code") String auth_code
        );

        @POST("user/signin")
        @FormUrlEncoded
        Observable<DriverSignInResponse> signin(
                @Field("mobile") String mobile,
                @Field("password") String password
        );

    }
}
