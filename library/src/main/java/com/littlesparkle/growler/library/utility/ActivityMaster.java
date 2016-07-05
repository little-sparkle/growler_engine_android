package com.littlesparkle.growler.library.utility;

import com.littlesparkle.growler.library.activity.BaseActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dell on 2016/7/2.
 */
public class ActivityMaster {
    private static List<BaseActivity> mAllActivities = new ArrayList<>();

    //添加一个Activity进入管理
    public static void addActivityToMaster(BaseActivity baseActivity) {
        mAllActivities.add(baseActivity);

    }

    //删除一个Activity进入管理
    public static void delActivityToMaster(BaseActivity baseActivity) {
        mAllActivities.remove(baseActivity);
    }

    //获取指定的某一个Activity
    public static BaseActivity getActivity(Class baseActivityClass) {
        for (BaseActivity baseActivity : mAllActivities) {
            if (baseActivity.getClass() == baseActivityClass) {
                return baseActivity;
            }
        }
        return null;
    }

    //销毁全部的Activity
    public static void killAll() {
        Iterator<BaseActivity> iterator = mAllActivities.iterator();
        while (iterator.hasNext()) {
            iterator.next().killself();
        }
    }

    //销毁某一个的Activity
    public static void killOne(Class baseActivityClass) {
        Iterator<BaseActivity> iterator = mAllActivities.iterator();
        while (iterator.hasNext()) {
            BaseActivity baseActivity = iterator.next();
            if (baseActivity.getClass() == baseActivityClass) {
                baseActivity.killself();
            }

        }

    }
}
