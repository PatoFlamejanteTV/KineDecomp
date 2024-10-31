package com.google.android.gms.common.internal;

import android.os.Looper;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class zzx {
    public static int a(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        return i;
    }

    public static int a(int i, Object obj) {
        if (i == 0) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return i;
    }

    public static <T> T a(T t) {
        if (t == null) {
            throw new NullPointerException("null reference");
        }
        return t;
    }

    public static <T> T a(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    public static String a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static void b(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void b(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void c(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }
}
