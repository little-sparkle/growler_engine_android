package com.littlesparkle.growler.library.user;

import android.content.Context;

import com.littlesparkle.growler.library.bean.Bean;
import com.littlesparkle.growler.library.bean.BeanHelper;
import com.littlesparkle.growler.library.bean.Car;
import com.littlesparkle.growler.library.bean.CarBrand;
import com.littlesparkle.growler.library.bean.CarSerie;
import com.littlesparkle.growler.library.bean.Driver;
import com.littlesparkle.growler.library.bean.User;
import com.littlesparkle.growler.library.preference.PrefHelper;

public class UserManager {
    private static Class<Bean>[] CLASS_ARRAY = new Class[]{
            User.class,
            Driver.class,
            Car.class,
            CarBrand.class,
            CarSerie.class
    };

    public static boolean isSignedIn(Context context) {
        return PrefHelper.getBoolean(context, "is-signed-in", false);
    }

    public static void signIn(Context context) {
        PrefHelper.setBoolean(context, "is-signed-in", true);
    }

    public static void signOut(Context context) {
        PrefHelper.setBoolean(context, "is-signed-in", false);
        for (Class<Bean> cls : CLASS_ARRAY) {
            BeanHelper.clean(context, cls);
        }
    }

    public static String getToken(Context context) {
        return PrefHelper.getString(context, "token");
    }

    public static void setToken(Context context, String token) {
        PrefHelper.setString(context, "token", token);
    }
}
