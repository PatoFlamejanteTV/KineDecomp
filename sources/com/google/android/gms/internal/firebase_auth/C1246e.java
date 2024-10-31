package com.google.android.gms.internal.firebase_auth;

/* renamed from: com.google.android.gms.internal.firebase_auth.e */
/* loaded from: classes2.dex */
final class C1246e {

    /* renamed from: a */
    private static final Class<?> f13021a = a("libcore.io.Memory");

    /* renamed from: b */
    private static final boolean f13022b;

    static {
        f13022b = a("org.robolectric.Robolectric") != null;
    }

    public static boolean a() {
        return (f13021a == null || f13022b) ? false : true;
    }

    public static Class<?> b() {
        return f13021a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
