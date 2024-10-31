package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class Z {

    /* renamed from: a */
    private static final Class<?> f13197a = a("libcore.io.Memory");

    /* renamed from: b */
    private static final boolean f13198b;

    static {
        f13198b = a("org.robolectric.Robolectric") != null;
    }

    public static boolean a() {
        return (f13197a == null || f13198b) ? false : true;
    }

    public static Class<?> b() {
        return f13197a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
