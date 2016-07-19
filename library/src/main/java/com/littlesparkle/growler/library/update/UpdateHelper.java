package com.littlesparkle.growler.library.update;

import android.content.Context;
import android.support.annotation.NonNull;

import com.littlesparkle.growler.library.http.BaseHttpSubscriber;
import com.littlesparkle.growler.library.http.api.ApiException;
import com.littlesparkle.growler.library.misc.MiscHelper;

import rx.Subscriber;

public class UpdateHelper {

    public static final void checkUpdate(
            @NonNull final Context context,
            @NonNull final Subscriber subscriber,
            @NonNull final String url) {
        String version = MiscHelper.getVersionName(context);
        String packageName = MiscHelper.getPackageName(context);
        new UpdateRequest(url).update(subscriber, packageName, version);
    }

    public static final void checkUpdate(
            @NonNull final Context context,
            @NonNull final String url,
            @NonNull final UpdateListener listener) {

        Subscriber subscriber = new BaseHttpSubscriber<UpdateResponse>() {
            @Override
            public void onNext(UpdateResponse updateResponse) {
                listener.onUpdateAvailable(updateResponse.data);
            }

            @Override
            protected void onError(String message) {
                listener.onNoUpdate();
            }
        };

        String version = MiscHelper.getVersionName(context);
        String packageName = MiscHelper.getPackageName(context);
        new UpdateRequest(url).update(subscriber, packageName, version);
    }
}
