package com.littlesparkle.growler.library.bean;

import android.content.Context;

public class Bean {
    public void persist(Context context) {
        BeanHelper.persist(context, this);
    }

    public void load(Context context) {
        BeanHelper.load(context, this);
    }

    public void dump() {
        BeanHelper.dump(this);
    }
}
