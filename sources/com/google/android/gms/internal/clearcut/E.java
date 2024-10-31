package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
final class E {

    /* renamed from: a */
    private static final B<?> f12769a = new C();

    /* renamed from: b */
    private static final B<?> f12770b = c();

    public static B<?> a() {
        return f12769a;
    }

    public static B<?> b() {
        B<?> b2 = f12770b;
        if (b2 != null) {
            return b2;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static B<?> c() {
        try {
            return (B) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
