package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.ba */
/* loaded from: classes2.dex */
final class C1349ba {

    /* renamed from: a */
    private static final Class<?> f13422a = a("libcore.io.Memory");

    /* renamed from: b */
    private static final boolean f13423b;

    static {
        f13423b = a("org.robolectric.Robolectric") != null;
    }

    public static boolean a() {
        return (f13422a == null || f13423b) ? false : true;
    }

    public static Class<?> b() {
        return f13422a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
