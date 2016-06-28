package com.littlesparkle.growler.library.utility;

import android.content.Context;
import android.telephony.TelephonyManager;

public class Device {
    public static String getDeviceId(Context context) {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE))
                .getDeviceId();
    }

    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static String getBrand() {
        return android.os.Build.BOARD;
    }

    public static String getModel() {
        return android.os.Build.MODEL;
    }
}
