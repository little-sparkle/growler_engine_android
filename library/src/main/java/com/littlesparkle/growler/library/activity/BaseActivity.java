package com.littlesparkle.growler.library.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

public abstract class BaseActivity extends AppCompatActivity {
    public LayoutInflater mLayoutInflater;
    public BaseActivity mBaseActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutInflater = this.getLayoutInflater();
        mBaseActivity = this;
        setContentView(getLayoutResId());
        initData();
        initView();
    }

    protected void initView() {
    }

    protected void initData() {
    }

    protected void startActivity(Class Activity) {
        Intent intent = new Intent(this, Activity);
        startActivity(intent);
    }

    protected void startService(Class service) {
        Intent intent = new Intent(this, service);
        startService(intent);
    }

    protected abstract int getLayoutResId();

}
