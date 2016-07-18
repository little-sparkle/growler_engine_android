package com.littlesparkle.growler.library.activity;

import android.os.Bundle;

import com.littlesparkle.growler.library.R;

public class BaseRegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_base_register;
    }
}
