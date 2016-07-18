package com.littlesparkle.growler.library.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.TextView;

import com.littlesparkle.growler.library.R;

public abstract class BaseForgetPwdActivity extends BaseActivity {

    protected AppCompatEditText mMobileInput;
    protected AppCompatEditText mAuthCodeInput;
    protected AppCompatEditText mPwdInput;
    protected AppCompatEditText mPwdConfInput;
    protected AppCompatButton mResetPwdBtn;
    protected TextView mSendAuthCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_base_forget_pwd;
    }

    @Override
    protected void initView() {
        mMobileInput = (AppCompatEditText) findViewById(R.id.input_mobile);
        mAuthCodeInput = (AppCompatEditText) findViewById(R.id.input_auth_code);
        mPwdInput = (AppCompatEditText) findViewById(R.id.input_password);
        mPwdConfInput = (AppCompatEditText) findViewById(R.id.input_password_confirmation);
        mResetPwdBtn = (AppCompatButton) findViewById(R.id.reset_pwd_button);
        mResetPwdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResetPwdClick();
            }
        });
        mSendAuthCode = (TextView) findViewById(R.id.send_auth_code);
        mSendAuthCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSendAuthCodeClick();
            }
        });
    }

    protected abstract void onSendAuthCodeClick();

    protected abstract void onResetPwdClick();
}
