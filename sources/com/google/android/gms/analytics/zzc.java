package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.zzae;

/* loaded from: classes.dex */
public final class zzc {
    public static String a(int i) {
        return a("cd", i);
    }

    private static String a(String str, int i) {
        if (i >= 1) {
            return str + i;
        }
        zzae.a("index out of range for prefix", str);
        return "";
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
        return a("promo", i);
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

    public static String j(int i) {
        return a("cd", i);
    }

    public static String k(int i) {
        return a("cm", i);
    }
}
