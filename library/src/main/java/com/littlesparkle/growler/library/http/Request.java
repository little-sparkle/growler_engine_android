package com.littlesparkle.growler.library.http;

import android.support.annotation.NonNull;

import com.littlesparkle.growler.library.http.api.Api;
import com.littlesparkle.growler.library.http.converter.ConvertFactory;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public abstract class Request<T> {

    protected Retrofit mRetrofit = null;

    protected T mService = null;

    public Request() {
        this(Api.BASE_URL);
    }

    public Request(@NonNull String baseUrl) {
        mRetrofit = new Retrofit.Builder()
                .client(createHttpClientBuilder().build())
                .addConverterFactory(ConvertFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();

        mService = mRetrofit.create(getServiceClass());
    }

    protected OkHttpClient.Builder createHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(Api.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Api.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(Api.WRITE_TIMEOUT, TimeUnit.SECONDS);
    }

    protected abstract Class<T> getServiceClass();
}
