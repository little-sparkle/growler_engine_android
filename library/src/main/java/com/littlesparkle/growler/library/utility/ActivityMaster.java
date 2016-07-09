package com.littlesparkle.growler.library.utility;

import com.littlesparkle.growler.library.activity.BaseFragmentActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dell on 2016/7/2.
 */
public class ActivityMaster {
    private static List<BaseFragmentActivity> mAllActivities = new ArrayList<>();

    //添加一个Activity进入管理
    public static void addActivityToMaster(BaseFragmentActivity baseFragmentActivity) {
        mAllActivities.add(baseFragmentActivity);

    }

    //删除一个Activity进入管理
    public static void delActivityToMaster(BaseFragmentActivity baseFragmentActivity) {
        mAllActivities.remove(baseFragmentActivity);
    }

    //获取指定的某一个Activity
    public static BaseFragmentActivity getActivity(Class baseActivityClass) {
        for (BaseFragmentActivity baseFragmentActivity : mAllActivities) {
            if (baseFragmentActivity.getClass() == baseActivityClass) {
                return baseFragmentActivity;
            }
        }
        return null;
    }

    //销毁全部的Activity
    public static void killAll() {
        Iterator<BaseFragmentActivity> iterator = mAllActivities.iterator();
        while (iterator.hasNext()) {
            iterator.next().killself();
        }
    }

    //销毁某一个的Activity
    public static void killOne(Class baseActivityClass) {
        Iterator<BaseFragmentActivity> iterator = mAllActivities.iterator();
        while (iterator.hasNext()) {
            BaseFragmentActivity baseFragmentActivity = iterator.next();
            if (baseFragmentActivity.getClass() == baseActivityClass) {
                baseFragmentActivity.killself();
            }

        }

    }
}
