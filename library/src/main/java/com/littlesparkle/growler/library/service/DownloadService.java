package com.littlesparkle.growler.library.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.math.BigDecimal;

import de.greenrobot.event.EventBus;

public class DownloadService extends Service {


    public DownloadService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String url = intent.getStringExtra("url");

        url = "https://github.com/wyouflf/xUtils3/archive/master.zip";

        RequestParams params = new RequestParams(url);
        //设置断点续传
        params.setAutoResume(true);

        params.setSaveFilePath("/storage/emulated/0/Download/master.zip");

        x.http().get(params, new Callback.ProgressCallback<File>() {


            @Override
            public void onSuccess(File result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public void onWaiting() {

            }

            @Override
            public void onStarted() {

            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                BigDecimal b = new BigDecimal((float) current / (float) total);
                float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                EventBus.getDefault().post(f1);
            }
        });

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
