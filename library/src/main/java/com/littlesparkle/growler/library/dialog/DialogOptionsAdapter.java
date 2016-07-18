package com.littlesparkle.growler.library.dialog;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.littlesparkle.growler.library.R;
import com.littlesparkle.growler.library.base.NormalBaseAdapter;

import java.util.ArrayList;

public class DialogOptionsAdapter extends NormalBaseAdapter<String, DialogOptionsAdapter.ViewHolder> {

    public DialogOptionsAdapter(Context context, @LayoutRes int resource, int[] dataList) {
        super(context, resource);
        mDataList = new ArrayList<>();
        for (int i : dataList) {
            mDataList.add(context.getString(i));
        }
    }

    @Override
    protected ViewHolder onCreateViewHolder(ViewGroup parent, View convertView) {
        return new ViewHolder(convertView);
    }

    @Override
    protected void onBindViewHolder(ViewHolder holder, String item, int position) {
        holder.text.setText(item);
        if (isLastItem(position)) {
            holder.divider.setVisibility(View.GONE);
        } else {
            holder.divider.setVisibility(View.VISIBLE);
        }
    }

    public class ViewHolder extends NormalBaseAdapter.ViewHolder {
        private TextView text;
        private View divider;

        public ViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(R.id.option_text);
            divider = v.findViewById(R.id.option_divider);
        }
    }
}
