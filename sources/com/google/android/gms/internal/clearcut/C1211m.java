package com.google.android.gms.internal.clearcut;

/* renamed from: com.google.android.gms.internal.clearcut.m */
/* loaded from: classes2.dex */
final class C1211m {

    /* renamed from: a */
    private static final Class<?> f12855a = a("libcore.io.Memory");

    /* renamed from: b */
    private static final boolean f12856b;

    static {
        f12856b = a("org.robolectric.Robolectric") != null;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a() {
        return (f12855a == null || f12856b) ? false : true;
    }

    public static Class<?> b() {
        return f12855a;
    }
}
