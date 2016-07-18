package com.littlesparkle.growler.library.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

public abstract class RecyclerBaseAdapter<T extends RecyclerView.ViewHolder, D>
        extends RecyclerView.Adapter<T>
        implements View.OnClickListener {
    protected LayoutInflater mInflater;
    protected Context mContext = null;
    protected List<D> mDataList = null;
    protected OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public RecyclerBaseAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, v.getTag());
        }
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
        if (mDataList != null) {
            D d = mDataList.get(position);
            if (d != null) {
                holder.itemView.setTag(d);
                holder.itemView.setOnClickListener(this);
                onBindViewHolderItem(holder, d);
            }
        }
    }

    protected abstract void onBindViewHolderItem(T holder, D item);

    @Override
    public int getItemCount() {
        if (mDataList != null) {
            return mDataList.size();
        }
        return 0;
    }

    public void setDataList(List<D> dataList) {
        mDataList = dataList;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, Object object);
    }
}
