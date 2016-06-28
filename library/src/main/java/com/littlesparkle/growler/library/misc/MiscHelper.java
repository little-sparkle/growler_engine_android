package com.littlesparkle.growler.library.misc;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiscHelper {

    public static final int ONE_SECOND = 1000;
    public static final int TWO_SECOND = 2000;
    public static final int THREE_SECOND = 3000;
    public static final int ONE_MINUTE = ONE_SECOND * 60;

    public static boolean checkPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.trim();
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }

    public static boolean checkPassword(String password) {
        password = password.trim();
        if (password.length() < 6 || password.length() > 16) {
            return false;
        }

        Pattern p = Pattern
                .compile("^[A-Za-z0-9]+$");
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public static String getStringDate(int time) {
        if (time < 0) {
            time = 0;
        }
        Date currentTime = new Date(time * 1000);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(currentTime);
    }

    public static String getVersionName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getVersionCode(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getPackageName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.packageName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
