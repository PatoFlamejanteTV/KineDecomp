package com.google.android.gms.internal.firebase_auth;

/* renamed from: com.google.android.gms.internal.firebase_auth.y */
/* loaded from: classes2.dex */
final class C1285y {

    /* renamed from: a */
    private static final AbstractC1281w<?> f13092a = new C1283x();

    /* renamed from: b */
    private static final AbstractC1281w<?> f13093b = c();

    public static AbstractC1281w<?> a() {
        return f13092a;
    }

    public static AbstractC1281w<?> b() {
        AbstractC1281w<?> abstractC1281w = f13093b;
        if (abstractC1281w != null) {
            return abstractC1281w;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static AbstractC1281w<?> c() {
        try {
            return (AbstractC1281w) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
