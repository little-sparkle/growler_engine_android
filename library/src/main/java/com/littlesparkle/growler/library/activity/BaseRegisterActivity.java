package com.littlesparkle.growler.library.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.littlesparkle.growler.library.R;

public abstract class BaseRegisterActivity extends BaseActivity {
    protected EditText mMobileInput;
    protected EditText mAuthCodeInput;
    protected EditText mPwdInput;
    protected EditText mPwdConfInput;
    protected AppCompatButton mRegisterBtn;
    protected TextView mSendAuthCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_base_register;
    }

    @Override
    protected void initView() {
        mMobileInput = (EditText) findViewById(R.id.input_mobile);
        mAuthCodeInput = (EditText) findViewById(R.id.input_auth_code);
        mPwdInput = (EditText) findViewById(R.id.input_password);
        mPwdConfInput = (EditText) findViewById(R.id.input_password_confirmation);
        mRegisterBtn = (AppCompatButton) findViewById(R.id.register_button);
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterClick();
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

    protected abstract void onRegisterClick();
}
