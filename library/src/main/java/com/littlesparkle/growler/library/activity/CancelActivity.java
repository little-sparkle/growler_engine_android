package com.littlesparkle.growler.library.activity;


import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.littlesparkle.growler.library.R;
import com.littlesparkle.growler.library.adapter.ItemLvCancelAdapter;

import java.util.List;

public abstract class CancelActivity extends BaseTitleBarActivity {

    protected ListView mListView;
    protected ItemLvCancelAdapter mItemLvCancelAdapter;
    protected Button mButtonCancel;
    protected Button mButtonNotCancel;

    public abstract List<String> setReasonList();

    @Override
    protected void initView() {
        super.initView();
        mButtonNotCancel= (Button) findViewById(R.id.bt_not_cancel);
        mButtonNotCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNotCancelButtonClick();
            }
        });
        mButtonCancel = (Button) findViewById(R.id.bt_cancel);
        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCancelButtonClick();
            }
        });
        mListView = (ListView) findViewById(R.id.lv_cancel);
        if (mItemLvCancelAdapter == null) {
            mItemLvCancelAdapter = new ItemLvCancelAdapter(this, R.layout.item_lv_cancel_adapter, setReasonList());
        }
        mListView.setAdapter(mItemLvCancelAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onCancelLvItemClick(parent, view, position, id);
            }
        });
    }

    protected abstract void onNotCancelButtonClick();

    protected abstract void onCancelButtonClick();

    protected abstract void onCancelLvItemClick(AdapterView<?> parent, View view, int position, long id);

    @Override
    protected int getTitleResourceId() {
        return R.string.cancelOrder;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_cancel;
    }
}
