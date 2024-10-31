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
import com.facebook.places.model.PlaceFields;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* compiled from: UserInfo.java */
/* loaded from: classes.dex */
public class N {
    private static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b() {
        return "com.nexstreaming.app.kinemasterfree";
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("nex_tl_app_id", null);
        if (string != null) {
            return string;
        }
        String a2 = a(Settings.Secure.getString(context.getContentResolver(), "android_id") + b(context));
        if (a2 != null) {
            defaultSharedPreferences.edit().putString("nex_tl_app_id", a2).apply();
        }
        return a2;
    }

    public static String d(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            str = "";
        }
        Log.e("[UserInfo]", "Version Information ===== ");
        Log.e("[UserInfo]", "version name : " + str);
        return str;
    }

    public static String e(Context context) {
        int phoneType = ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getPhoneType();
        return (phoneType == 2 || phoneType == 1) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1";
    }

    public static String f() {
        return Build.DISPLAY;
    }

    public static String g() {
        return Build.VERSION.RELEASE;
    }

    public static String e() {
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.US);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.US);
        String lowerCase3 = locale.getVariant().toLowerCase(Locale.US);
        if (lowerCase3.isEmpty() && lowerCase2.isEmpty()) {
            return lowerCase;
        }
        if (lowerCase3.isEmpty()) {
            return lowerCase + "-" + lowerCase2;
        }
        if (lowerCase2.isEmpty()) {
            return lowerCase + "-" + lowerCase3;
        }
        return lowerCase + "-" + lowerCase2 + "-" + lowerCase3;
    }

    public static String c() {
        return Build.MANUFACTURER;
    }

    public static String d() {
        return Build.MODEL;
    }

    public static String a(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "(unknown)");
    }

    public static String a() {
        return c.d.b.a.a.f3576b.c();
    }
}
