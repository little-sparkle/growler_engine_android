package com.littlesparkle.growler.library.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.littlesparkle.growler.library.R;
import com.littlesparkle.growler.library.http.BaseHttpSubscriber;

import cn.pedant.SweetAlert.SweetAlertDialog;

public abstract class BaseActivity extends AppCompatActivity
        implements BaseHttpSubscriber.IToast, BaseHttpSubscriber.IProgress {

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

    private SweetAlertDialog mProgressDialog = null;

    @Override
    public void showProgress() {
        if (mProgressDialog == null) {
            mProgressDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
            mProgressDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            mProgressDialog.setTitleText(getString(R.string.please_waiting));
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.show();
    }

    @Override
    public void dismissProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.hide();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissToast() {
    }
}
