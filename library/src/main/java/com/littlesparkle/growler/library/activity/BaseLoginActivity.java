package com.littlesparkle.growler.library.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.littlesparkle.growler.library.R;

public abstract class BaseLoginActivity extends BaseActivity {
    protected EditText mMobileInput;
    protected EditText mPwdInput;
    protected AppCompatButton mLoginBtn;
    protected TextView mForgetPwd;
    protected TextView mToRegister;

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
        mMobileInput = (EditText) findViewById(R.id.input_mobile);
        mPwdInput = (EditText) findViewById(R.id.input_password);
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
        mToRegister = (TextView) findViewById(R.id.go_to_register);
        mToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterClick();
            }
        });
    }

    protected abstract void onRegisterClick();

    protected abstract void onForgetPasswordClick();

    protected abstract void onLoginClick();
}
