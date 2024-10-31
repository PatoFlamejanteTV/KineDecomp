package c.d.b.c;

import android.content.Context;
import android.preference.PreferenceManager;
import com.google.firebase.messaging.FirebaseMessaging;
import com.nexstreaming.kinemaster.ad.AdManager;
import com.nexstreaming.kinemaster.usage.analytics.d;
import java.util.Date;

/* compiled from: GDPRManager.java */
/* loaded from: classes.dex */
public class a {
    public static void a(Context context, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("pref_gdpr_ads", z).putLong("pref_gdpr_ads_submit_time", new Date().getTime()).apply();
    }

    public static boolean a() {
        return false;
    }

    public static void b(Context context, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("pref_gdpr_echosystem", z).putLong("pref_gdpr_echosystem_submit_time", new Date().getTime()).apply();
    }

    public static boolean c(Context context) {
        return !a() || PreferenceManager.getDefaultSharedPreferences(context).getBoolean("pref_gdpr_ads", false);
    }

    public static boolean d(Context context) {
        return !a() || PreferenceManager.getDefaultSharedPreferences(context).getBoolean("pref_gdpr_echosystem", false);
    }

    public static boolean e(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("pref_is_gdpr_checked", false);
    }

    private static void f(Context context, boolean z) {
        b(context, z);
        d(context, d(context));
        com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().a(context, d(context));
    }

    public static long a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("pref_gdpr_ads_submit_time", new Date().getTime());
    }

    public static long b(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("pref_gdpr_echosystem_submit_time", new Date().getTime());
    }

    public static void c(Context context, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("pref_is_gdpr_checked", z).apply();
    }

    public static void d(Context context, boolean z) {
        d.f23910b.a(context, z);
        FirebaseMessaging.a().a(z);
    }

    private static void e(Context context, boolean z) {
        a(context, z);
        AdManager.a(context, c(context));
    }

    public static void a(Context context, int i, boolean z, boolean z2) {
        if (i == 1) {
            f(context, z);
        } else if (i != 2) {
            f(context, z);
            e(context, z2);
        } else {
            e(context, z2);
        }
        c(context, true);
    }
}
