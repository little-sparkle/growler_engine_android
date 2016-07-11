package com.littlesparkle.growler.library.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.littlesparkle.growler.library.R;

import java.util.ArrayList;
import java.util.List;

public class OptionItemAdapter extends BaseAdapter {
    private List<String> mDataList;

    private final Context mContext;
    private final LayoutInflater mInflater;
    private final int mResource;

    public OptionItemAdapter(Context context, @LayoutRes int resource) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
    }

    public OptionItemAdapter(Context context, @LayoutRes int resource, List<String> dataList) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        mDataList = dataList;
    }

    public OptionItemAdapter(Context context, @LayoutRes int resource, int[] dataList) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        mDataList = new ArrayList<>();
        for (int i : dataList) {
            mDataList.add(context.getString(i));
        }
    }

    public void setDataList(List<String> dataList) {
        mDataList = dataList;
    }

    @Override
    public int getCount() {
        if (mDataList != null) {
            return mDataList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mDataList != null && position < mDataList.size()) {
            return mDataList.get(position);
        }
        return null;
    }

    private boolean isLastItem(int position) {
        if (mDataList != null && (position + 1 == mDataList.size())) {
            return true;
        }
        return false;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(mInflater, position, convertView, parent, mResource);
    }

    private View createViewFromResource(LayoutInflater inflater, int position, View convertView,
                                        ViewGroup parent, int resource) {
        View view;
        if (convertView == null) {
            view = inflater.inflate(resource, parent, false);
        } else {
            view = convertView;
        }

        TextView text = (TextView) view.findViewById(R.id.option_text);
        text.setText(getItem(position).toString());

        View divider = view.findViewById(R.id.option_divider);
        if (isLastItem(position)) {
            divider.setVisibility(View.GONE);
        } else {
            divider.setVisibility(View.VISIBLE);
        }

        return view;
    }
}
