package com.littlesparkle.growler.library.activity;

import android.os.Handler;
import android.os.Message;

public abstract class HandlerActivity extends BaseActivity {

    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            onHandlerMessage(msg);
        }
    };

    protected void onHandlerMessage(Message msg) {
    }
}
