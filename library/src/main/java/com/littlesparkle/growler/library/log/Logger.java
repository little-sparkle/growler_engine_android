package com.littlesparkle.growler.library.log;

import android.util.Log;

public class Logger {
    private static String TAG = "growler-library";

    public static void init(String tag) {
        if (!"".equals(tag)) {
            TAG = tag;
        }
    }

    public static void log(String msg) {
        log(TAG, msg);
    }

    public static void log(String tag, String msg) {
        w(tag, msg);
    }

    public static void i(String msg) {
        Log.d(TAG, msg);
    }

    public static void i(String tag, String msg) {
        Log.d(TAG + ":" + tag, msg);
    }

    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        Log.d(TAG + ":" + tag, msg);
    }

    public static void w(String msg) {
        Log.w(TAG, msg);
    }

    public static void w(String tag, String msg) {
        Log.w(TAG + ":" + tag, msg);
    }

    public static void e(String msg) {
        Log.e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        Log.e(TAG + ":" + tag, msg);
    }
}
