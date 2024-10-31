package com.nexstreaming.kinemaster.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: NetworkManager.java */
/* loaded from: classes.dex */
public class a {
    public static boolean a(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    public static boolean b(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    public static boolean c(Context context) {
        return a(context) || b(context);
    }

    public static int d(Context context) {
        if (context == null) {
            return 0;
        }
        int i = context.getResources().getConfiguration().mcc;
        if (i == 0) {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                try {
                    return Integer.parseInt(networkOperator.substring(0, 3));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return i;
    }

    public static String e(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getConfiguration().locale.getCountry();
    }

    public static boolean a() {
        String country = Locale.getDefault().getCountry();
        if (country == null) {
            return false;
        }
        return country.equalsIgnoreCase(Locale.SIMPLIFIED_CHINESE.getCountry());
    }

    public static boolean b() {
        String country = Locale.getDefault().getCountry();
        if (country == null) {
            return false;
        }
        return country.equalsIgnoreCase(Locale.TRADITIONAL_CHINESE.getCountry());
    }

    public static boolean f(Context context) {
        String e;
        if (context == null) {
            return false;
        }
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("disable_iab_mcc_checker", false)) {
            return true;
        }
        boolean z = d(context) == 460;
        if (!z && (e = e(context)) != null) {
            return e.equalsIgnoreCase(Locale.CHINA.getCountry());
        }
        return z;
    }

    public static void a(Context context, long j) {
        if (context != null && j > 0) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("network_current", j).apply();
        }
    }

    public static long g(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (context != null) {
            return Math.max(currentTimeMillis, PreferenceManager.getDefaultSharedPreferences(context).getLong("network_current", 0L) * 1000);
        }
        return currentTimeMillis;
    }
}
