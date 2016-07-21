package com.littlesparkle.growler.library.user;


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

public class UserRequest extends Request<UserRequest.UserApi> {

    public Subscription mobileCheck(Subscriber<DefaultResponse> subscriber,
                                    String mobile) {
        return mService.mobileCheck(mobile)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public Subscription signupSendSms(Subscriber<DefaultResponse> subscriber,
                                      String mobile) {
        return mService.signupSendSms(mobile)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public Subscription signin(Subscriber<UserSignInResponse> subscriber,
                               String mobile, String password) {
        return mService.signin(mobile, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public Subscription signup(Subscriber<UserSignUpResponse> subscriber,
                               String mobile, String password, String auth_code) {
        return mService.signup(mobile, password, auth_code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public Subscription signout(Subscriber<DefaultResponse> subscriber,
                                int userId, String token) {
        return mService.signout(userId, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    @Override
    protected Class<UserApi> getServiceClass() {
        return UserApi.class;
    }

    public interface UserApi {
        @POST("user/mobile_check")
        @FormUrlEncoded
        Observable<DefaultResponse> mobileCheck(
                @Field("mobile") String mobile
        );

        @POST("user/signup_send_sms")
        @FormUrlEncoded
        Observable<DefaultResponse> signupSendSms(
                @Field("mobile") String mobile
        );

        @POST("user/signup")
        @FormUrlEncoded
        Observable<UserSignUpResponse> signup(
                @Field("mobile") String mobile,
                @Field("password") String password,
                @Field("auth_code") String auth_code
        );

        @POST("user/signin")
        @FormUrlEncoded
        Observable<UserSignInResponse> signin(
                @Field("mobile") String mobile,
                @Field("password") String password
        );

        @POST("user/signout")
        @FormUrlEncoded
        Observable<DefaultResponse> signout(
                @Field("user_id") int userId,
                @Field("token") String token
        );

        @POST("user/rate")
        @FormUrlEncoded
        Observable<DefaultResponse> rate(
                @Field("user_id") int userId,
                @Field("token") String token,
                @Field("order_id") int orderId,
                @Field("rate") int rate
        );
    }
}
