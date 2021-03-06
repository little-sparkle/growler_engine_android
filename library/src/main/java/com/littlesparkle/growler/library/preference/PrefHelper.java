package com.littlesparkle.growler.library.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.f2prateek.rx.preferences.RxSharedPreferences;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class PrefHelper {

    public static int getInteger(Context context, String key) {
        return getInteger(context, key, 0);
    }

    public static int getInteger(Context context, String key, int defaultValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
        return rxPreferences.getInteger(key, defaultValue).get();
    }

    public static long getLong(Context context, String key, long defaultValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
        return rxPreferences.getLong(key, defaultValue).get();
    }

    public static float getFloat(Context context, String key, float defaultValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
        return rxPreferences.getFloat(key, defaultValue).get();
    }

    public static double getDouble(Context context, String key, double defaultValue) {
        return getFloat(context, key, (float) defaultValue);
    }

    public static String getString(Context context, String key) {
        return getString(context, key, "");
    }

    public static String getString(Context context, String key, String defaultValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
        return rxPreferences.getString(key, defaultValue).get();
    }

    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, false);
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
        return rxPreferences.getBoolean(key, defaultValue).get();
    }

    public static Subscription observeBool(Context context, String key, Subscriber<Boolean> subscriber) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
        return rxPreferences
                .getBoolean(key)
                .asObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void delete(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
        rxPreferences.getString(key).delete();
    }

    public static void setString(Context context, String key, String value) {
        if (!"".equals(key) && !"".equals(value)) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
            rxPreferences.getString(key).set(value);
        }
    }

    public static void setInteger(Context context, String key, int value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
        rxPreferences.getInteger(key).set(value);
    }

    public static void setBoolean(Context context, String key, boolean value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
        rxPreferences.getBoolean(key).set(value);
    }

    public static void setLong(Context context, String key, long value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
        rxPreferences.getLong(key).set(value);
    }

    public static void setDouble(Context context, String key, double value) {
        setFloat(context, key, (float) value);
    }

    public static void setFloat(Context context, String key, float value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
        rxPreferences.getFloat(key).set(value);
    }
}
