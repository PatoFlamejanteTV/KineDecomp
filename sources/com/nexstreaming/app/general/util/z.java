package com.nexstreaming.app.general.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* compiled from: UserInfo.java */
/* loaded from: classes.dex */
public class z {
    private static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("nex_tl_app_id", null);
        if (string == null) {
            string = a(Settings.Secure.getString(context.getContentResolver(), "android_id") + d(context));
            if (string != null) {
                defaultSharedPreferences.edit().putString("nex_tl_app_id", string).apply();
            }
        }
        return string;
    }

    public static String b(Context context) {
        int phoneType = ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
        if (phoneType == 2 || phoneType == 1) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }

    public static String c(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "(unknown)");
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String e(Context context) {
        String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Log.e("[UserInfo]", "Version Information ===== ");
        Log.e("[UserInfo]", "version name : " + str);
        return str;
    }

    public static String a() {
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.US);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.US);
        String lowerCase3 = locale.getVariant().toLowerCase(Locale.US);
        if (!lowerCase3.isEmpty() || !lowerCase2.isEmpty()) {
            if (lowerCase3.isEmpty()) {
                return lowerCase + "-" + lowerCase2;
            }
            if (lowerCase2.isEmpty()) {
                return lowerCase + "-" + lowerCase3;
            }
            return lowerCase + "-" + lowerCase2 + "-" + lowerCase3;
        }
        return lowerCase;
    }

    public static String b() {
        return Build.VERSION.RELEASE;
    }

    public static String c() {
        return Build.DISPLAY;
    }

    public static String d() {
        return Build.MODEL;
    }

    public static String e() {
        return Build.MANUFACTURER;
    }

    public static String f() {
        return a(true);
    }

    public static String g() {
        return a(false);
    }

    private static String a(boolean z) {
        String str;
        String a2;
        String a3 = NexEditor.a("ro.board.platform");
        if (a3 != null && a3.trim().equalsIgnoreCase("msm8916")) {
            a3 = NexEditor.a("ro.product.board");
            if (!a3.trim().equalsIgnoreCase("msm8939")) {
                a3 = NexEditor.a("ro.board.platform");
            }
        }
        if (a3 != null && a3.trim().equalsIgnoreCase("msm8960") && (a2 = NexEditor.a("ro.product.board")) != null && a2.trim().equalsIgnoreCase("8x30")) {
            a3 = "MSM8x30n";
        }
        if (z || a3 == null || !a3.equalsIgnoreCase("exynos5") || (str = NexEditor.a("ro.product.board")) == null || !str.startsWith("universal") || str.startsWith("universal5")) {
            str = a3;
        }
        if (str == null || str.trim().length() < 1) {
            str = NexEditor.a("ro.mediatek.platform");
        }
        if (str == null || str.trim().length() < 1) {
            str = NexEditor.a("ro.hardware");
        }
        if (str == null || str.trim().length() < 1) {
            return "unknown";
        }
        return str;
    }
}
