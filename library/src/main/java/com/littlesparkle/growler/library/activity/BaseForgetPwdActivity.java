package com.littlesparkle.growler.library.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.littlesparkle.growler.library.R;

public abstract class BaseForgetPwdActivity extends BaseTitleBarActivity {

    protected EditText mMobileInput;
    protected EditText mAuthCodeInput;
    protected EditText mPwdInput;
    protected EditText mPwdConfInput;
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
        super.initView();
        mMobileInput = (EditText) findViewById(R.id.input_mobile);
        mAuthCodeInput = (EditText) findViewById(R.id.input_auth_code);
        mPwdInput = (EditText) findViewById(R.id.input_password);
        mPwdConfInput = (EditText) findViewById(R.id.input_password_confirmation);
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

    @Override
    protected int getTitleResourceId() {
        return R.string.forget_password;
    }

    protected abstract void onSendAuthCodeClick();

    protected abstract void onResetPwdClick();
}
