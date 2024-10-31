package com.adobe.creativesdk.foundation.internal.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Base64;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a */
    private static Context f6916a;

    public static Context a() {
        return f6916a;
    }

    public static String b() {
        String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.UK).format(new Date());
        return format.substring(0, 26) + ":" + format.substring(26);
    }

    public static String c() {
        String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.UK).format(new Date());
        return format.substring(0, 26) + ":" + format.substring(26);
    }

    public static String d() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        return str + " " + str2;
    }

    public static String e() {
        if (a() != null) {
            try {
                return a().getPackageManager().getPackageInfo(a().getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, w.class.getName(), "Error during getProductVersion operation", e2);
            }
        }
        return "";
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(String.format("%02x", Integer.valueOf(b2 & 255)));
        }
        return sb.toString();
    }

    public static byte[] a(String str) {
        try {
            return Base64.decode(str.getBytes("UTF-8"), 2);
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, w.class.getName(), "Error during convertStringToByteArray operation", e2);
            return null;
        }
    }
}
