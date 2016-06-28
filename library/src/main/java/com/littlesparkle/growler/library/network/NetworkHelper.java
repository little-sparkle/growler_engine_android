package com.littlesparkle.growler.library.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkHelper {

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        return isConnectedWithType(context, ConnectivityManager.TYPE_WIFI);
    }

    public static boolean isMobileConnected(Context context) {
        return isConnectedWithType(context, ConnectivityManager.TYPE_MOBILE);
    }

    private static boolean isConnectedWithType(Context context, int type) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = mConnectivityManager
                    .getNetworkInfo(type);
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }

        return false;
    }
}
