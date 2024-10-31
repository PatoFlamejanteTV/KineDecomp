package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Lh {

    /* renamed from: a */
    private static final Jh<?> f11667a = new Kh();

    /* renamed from: b */
    private static final Jh<?> f11668b = c();

    public static Jh<?> a() {
        return f11667a;
    }

    public static Jh<?> b() {
        Jh<?> jh = f11668b;
        if (jh != null) {
            return jh;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static Jh<?> c() {
        try {
            return (Jh) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
