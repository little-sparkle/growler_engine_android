package com.littlesparkle.growler.library.activity;

import android.os.Bundle;

public abstract class BaseSplashActivity extends HandlerActivity {

    public static final int ONE_SECOND = 1000;
    private static final int MAX_COUNTER = 2;
    private int mRemainingSeconds = 0;

    private Runnable mUpdateRunnable = new Runnable() {
        public void run() {
            if (mRemainingSeconds == 0) {
                onSplashEnd();
            } else {
                mRemainingSeconds = mRemainingSeconds - 1;
                mHandler.postDelayed(this, ONE_SECOND);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUI();
    }

    protected abstract void onSplashEnd();

    protected int getMaxCounter() {
        return MAX_COUNTER;
    }

    private void initUI() {
        mRemainingSeconds = getMaxCounter();
        mHandler.postDelayed(mUpdateRunnable, ONE_SECOND);
    }
}
