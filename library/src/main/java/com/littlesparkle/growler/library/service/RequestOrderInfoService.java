package com.littlesparkle.growler.library.service;

import android.app.Service;
import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dell on 2016/7/28.
 */
public abstract class RequestOrderInfoService extends Service {

    Timer mTimer = null;


    //    startService 就可以开始轮询
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                getOrderInfo();
            }
        }, 3000, 3000);
        return super.onStartCommand(intent, flags, startId);
    }

    protected abstract void getOrderInfo();

    //      stopService 取消轮询
    @Override
    public void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
    }
}
