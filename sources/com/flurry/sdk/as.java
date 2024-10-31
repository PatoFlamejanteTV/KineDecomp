package com.flurry.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public final class as {

    /* renamed from: a, reason: collision with root package name */
    private static int f467a = LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT;
    private static boolean b = false;
    private static int c = 5;
    private static boolean d = false;

    public static int a() {
        return c;
    }

    public static boolean b() {
        return d;
    }

    public static void a(String str, String str2) {
        b(3, str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    public static void b(String str, String str2) {
        b(6, str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        b(5, str, str2, th);
    }

    public static void c(String str, String str2) {
        b(5, str, str2);
    }

    public static void a(int i, String str, String str2, Throwable th) {
        c(i, str, str2, th);
    }

    public static void a(int i, String str, String str2) {
        c(i, str, str2);
    }

    private static void b(int i, String str, String str2, Throwable th) {
        b(i, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    private static void b(int i, String str, String str2) {
        if (!b && c <= i) {
            d(i, str, str2);
        }
    }

    private static void c(int i, String str, String str2, Throwable th) {
        c(i, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    private static void c(int i, String str, String str2) {
        if (d) {
            d(i, str, str2);
        }
    }

    private static void d(int i, String str, String str2) {
        int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = f467a > length - i2 ? length : f467a + i2;
            if (Log.println(i, "FlurryAgent", str2.substring(i2, i3)) <= 0) {
                return;
            } else {
                i2 = i3;
            }
        }
    }
}
