package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.sh */
/* loaded from: classes2.dex */
final class C1083sh {

    /* renamed from: a */
    private static final Class<?> f12527a = a("libcore.io.Memory");

    /* renamed from: b */
    private static final boolean f12528b;

    static {
        f12528b = a("org.robolectric.Robolectric") != null;
    }

    public static boolean a() {
        return (f12527a == null || f12528b) ? false : true;
    }

    public static Class<?> b() {
        return f12527a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
