package com.google.android.gms.analytics;

import android.support.v4.app.NotificationCompat;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzch;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzd {
    public static String a(int i) {
        return a("cd", i);
    }

    public static String b(int i) {
        return a("cm", i);
    }

    public static String c(int i) {
        return a("&pr", i);
    }

    public static String d(int i) {
        return a("pr", i);
    }

    public static String e(int i) {
        return a("&promo", i);
    }

    public static String f(int i) {
        return a(NotificationCompat.CATEGORY_PROMO, i);
    }

    public static String g(int i) {
        return a("pi", i);
    }

    public static String h(int i) {
        return a("&il", i);
    }

    public static String i(int i) {
        return a("il", i);
    }

    private static String a(String str, int i) {
        if (i <= 0) {
            zzch.zzf("index out of range for prefix", str);
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11);
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }
}
