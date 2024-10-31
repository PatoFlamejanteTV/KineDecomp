package c.d.b.m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.Locale;

/* compiled from: NetworkManager.java */
/* loaded from: classes2.dex */
public class i {
    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        int i = context.getResources().getConfiguration().mcc;
        if (i == 0) {
            String networkOperator = ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                try {
                    return Integer.parseInt(networkOperator.substring(0, 3));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return i;
    }

    public static boolean b() {
        String country = Locale.getDefault().getCountry();
        if (country != null) {
            return country.equalsIgnoreCase(Locale.TRADITIONAL_CHINESE.getCountry());
        }
        return false;
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    public static boolean d(Context context) {
        if (context == null) {
            context = KineMasterApplication.f24056d.getApplicationContext();
        }
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("disable_iab_mcc_checker", false) || a.b()) {
            return true;
        }
        int a2 = a(context);
        if (a2 != 0) {
            return a2 == 460;
        }
        return Locale.CHINA.getCountry().equals(context.getResources().getConfiguration().locale.getCountry());
    }

    public static boolean e(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    public static boolean f(Context context) {
        if (context == null) {
            return false;
        }
        return g(context) || e(context) || c(context);
    }

    public static boolean g(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    public static long b(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        return context != null ? Math.max(currentTimeMillis, PreferenceManager.getDefaultSharedPreferences(context).getLong("network_current", 0L) * 1000) : currentTimeMillis;
    }

    public static boolean a() {
        String country = Locale.getDefault().getCountry();
        if (country != null) {
            return country.equalsIgnoreCase(Locale.SIMPLIFIED_CHINESE.getCountry());
        }
        return false;
    }

    public static void a(Context context, long j) {
        if (context == null || j <= 0) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("network_current", j).apply();
    }
}
