package com.littlesparkle.growler.library.activity;

import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.TextView;

import com.littlesparkle.growler.library.R;

public abstract class BaseTitleBarActivity extends BaseActivity {
    protected AppCompatImageView mBack;
    protected TextView mTitle;

    @Override
    protected void initView() {
        mBack = (AppCompatImageView) findViewById(R.id.base_title_bar_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mTitle = (TextView) findViewById(R.id.base_title_bar_text);
        mTitle.setText(getTitleResourceId());
    }

    protected abstract int getTitleResourceId();
}
