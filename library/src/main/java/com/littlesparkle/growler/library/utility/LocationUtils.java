package com.littlesparkle.growler.library.utility;

import android.content.Context;
import android.location.LocationManager;

import java.util.List;

public class LocationUtils {

    public static boolean hasGPSDevice(Context context) {
        LocationManager locationManager =
                (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (locationManager != null) {
            List<String> providers = locationManager.getAllProviders();
            if (providers != null) {
                return providers.contains(LocationManager.GPS_PROVIDER);
            }
        }
        return false;
    }

    public static boolean isLocationEnabled(Context context) {
        return (isGpsEnabled(context) || isNetworkEnabled(context));
    }

    public static boolean isNetworkEnabled(Context context) {
        return isEnabledWithType(context, LocationManager.NETWORK_PROVIDER);
    }

    public static boolean isGpsEnabled(Context context) {
        return isEnabledWithType(context, LocationManager.GPS_PROVIDER);
    }

    private static boolean isEnabledWithType(Context context, String type) {
        LocationManager locationManager
                = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(type);
    }
}
