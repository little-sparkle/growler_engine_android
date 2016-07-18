package com.littlesparkle.growler.library.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.TextView;

import com.littlesparkle.growler.library.R;

public abstract class BaseLoginActivity extends BaseActivity {
    protected AppCompatEditText mMobileInput;
    protected AppCompatEditText mPwdInput;
    protected AppCompatButton mLoginBtn;
    protected TextView mForgetPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_base_login;
    }

    @Override
    protected void initView() {
        mMobileInput = (AppCompatEditText) findViewById(R.id.input_mobile);
        mPwdInput = (AppCompatEditText) findViewById(R.id.input_password);
        mLoginBtn = (AppCompatButton) findViewById(R.id.login_button);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginClick();
            }
        });
        mForgetPwd = (TextView) findViewById(R.id.forget_password);
        mForgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onForgetPasswordClick();
            }
        });
    }

    protected abstract void onForgetPasswordClick();

    protected abstract void onLoginClick();
}
