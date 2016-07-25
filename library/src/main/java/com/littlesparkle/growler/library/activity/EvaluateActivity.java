package com.littlesparkle.growler.library.activity;

import android.view.View;
import android.widget.Button;

import com.hedgehog.ratingbar.RatingBar;
import com.littlesparkle.growler.library.R;

import java.io.BufferedReader;

/**
 * Created by dell on 2016/7/25.
 */
public abstract class EvaluateActivity extends BaseTitleBarActivity {

    protected RatingBar mRatingBar = null;
    protected Button mButtonEvaluate = null;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_evaluate;
    }

    @Override
    protected void initView() {
        super.initView();
        mButtonEvaluate = (Button) findViewById(R.id.bt_evaluate);
        mButtonEvaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEvaluateButtonClick();
            }
        });
        mRatingBar = (RatingBar) findViewById(R.id.ratingbar);
        mRatingBar.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float RatingCount) {
                getRatingCount(RatingCount);
            }
        });
    }

    public abstract void onEvaluateButtonClick();

    public abstract void getRatingCount(float ratingCount);
}
