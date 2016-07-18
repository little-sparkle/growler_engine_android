package com.littlesparkle.growler.library.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.littlesparkle.growler.library.R;

public abstract class BaseActivity extends AppCompatActivity {

    private static final int QUIT_CHECK_INTERNAL = 2000;
    protected boolean mIsDoubleClickToQuit = false;
    private long mQuitTimePoint = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initData();
        initView();
    }

    protected void initView() {
    }

    protected void initData() {
    }


    protected abstract int getLayoutResId();

    @Override
    public void onBackPressed() {
        if (!mIsDoubleClickToQuit) {
            super.onBackPressed();
        } else {
            if ((System.currentTimeMillis() - mQuitTimePoint) > QUIT_CHECK_INTERNAL) {
                Toast.makeText(getApplicationContext(), R.string.quit_confirmation,
                        Toast.LENGTH_SHORT).show();
                mQuitTimePoint = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        }
    }
}
