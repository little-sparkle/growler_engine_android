package com.littlesparkle.growler.library.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.littlesparkle.growler.library.R;

public abstract class BaseResetPwdActivity extends BaseTitleBarActivity {
    protected EditText mOriginalInput;
    protected EditText mPwdInput;
    protected EditText mPwdConfInput;
    protected AppCompatButton mResetPwdBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_base_reset_pwd;
    }

    @Override
    protected void initView() {
        super.initView();
        mOriginalInput = (EditText) findViewById(R.id.input_original_pwd);
        mPwdInput = (EditText) findViewById(R.id.input_new_pwd);
        mPwdConfInput = (EditText) findViewById(R.id.input_new_pwd_confirmation);
        mResetPwdBtn = (AppCompatButton) findViewById(R.id.reset_pwd_button);
        mResetPwdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResetPwdClick();
            }
        });
    }

    @Override
    protected int getTitleResourceId() {
        return R.string.reset_pwd;
    }

    protected abstract void onResetPwdClick();
}
