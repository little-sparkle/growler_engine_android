package com.littlesparkle.growler.library.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.littlesparkle.growler.library.R;
import com.littlesparkle.growler.library.http.BaseHttpSubscriber;
import com.littlesparkle.growler.library.log.Logger;

import cn.pedant.SweetAlert.SweetAlertDialog;

public abstract class BaseActivity extends AppCompatActivity
        implements BaseHttpSubscriber.IToast, BaseHttpSubscriber.IProgress {

    private static final int QUIT_CHECK_INTERNAL = 2000;
    protected boolean mIsDoubleClickToQuit = false;
    private long mQuitTimePoint = 0;

    private static final int MSG_SHOW_PROGRESS = 1;
    private static final int MSG_HIDE_PROGRESS = 2;
    private static final int MSG_SHOW_TOAST = 3;
    private static final int MSG_HIDE_TOAST = 4;
    private Handler mTipsHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SHOW_PROGRESS:
                    Logger.log("BaseActivity: show progress dialog");
                    if (mProgressDialog == null) {
                        mProgressDialog = new SweetAlertDialog(BaseActivity.this, SweetAlertDialog.PROGRESS_TYPE);
                        mProgressDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                        mProgressDialog.setTitleText(getString(R.string.please_waiting));
                        mProgressDialog.setCancelable(true);
                    }
                    if (!mProgressDialog.isShowing()) {
                        mProgressDialog.show();
                    }
                    break;
                case MSG_HIDE_PROGRESS:
                    Logger.log("BaseActivity: hide progress dialog");
                    if (mProgressDialog != null && mProgressDialog.isShowing()) {
                        mProgressDialog.dismiss();
                    }
                    break;
                case MSG_SHOW_TOAST:
                    Toast.makeText(BaseActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
                case MSG_HIDE_TOAST:
                    break;
                default:
                    break;
            }
        }
    };

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
        mTipsHandler.removeMessages(MSG_SHOW_PROGRESS);
        mTipsHandler.sendEmptyMessage(MSG_SHOW_PROGRESS);
    }

    @Override
    public void dismissProgress() {
        mTipsHandler.removeMessages(MSG_HIDE_PROGRESS);
        mTipsHandler.sendEmptyMessage(MSG_HIDE_PROGRESS);
    }

    @Override
    public void showToast(String msg) {
        mTipsHandler.removeMessages(MSG_SHOW_TOAST);
        mTipsHandler.sendMessage(mTipsHandler.obtainMessage(MSG_SHOW_TOAST, msg));
    }

    @Override
    public void dismissToast() {
    }
}
