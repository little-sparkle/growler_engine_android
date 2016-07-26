package com.littlesparkle.growler.library.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.littlesparkle.growler.library.R;
import com.littlesparkle.growler.library.base.NormalBaseAdapter;

import java.util.List;

/**
 * Created by dell on 2016/7/25.
 */
public class ItemLvCancelAdapter extends NormalBaseAdapter<String, ItemLvCancelAdapter.CancelViewHolder> {
    public ItemLvCancelAdapter(Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public ItemLvCancelAdapter(Context context, @LayoutRes int resource, List dataList) {
        super(context, resource, dataList);
    }

    @Override
    protected CancelViewHolder onCreateViewHolder(ViewGroup parent, View convertView) {
        return new CancelViewHolder(convertView);
    }

    @Override
    protected void onBindViewHolder(CancelViewHolder holder, String item, int position) {
        holder.mTextViewReason.setText(item);
    }


    public class CancelViewHolder extends NormalBaseAdapter.ViewHolder {
        private TextView mTextViewReason;

        public CancelViewHolder(View v) {
            super(v);
            mTextViewReason = (TextView) v.findViewById(R.id.tv_item_cancel_adapter);
        }
    }
}
