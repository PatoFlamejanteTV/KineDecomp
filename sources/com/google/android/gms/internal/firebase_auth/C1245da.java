package com.google.android.gms.internal.firebase_auth;

/* renamed from: com.google.android.gms.internal.firebase_auth.da */
/* loaded from: classes2.dex */
final class C1245da {

    /* renamed from: a */
    private static final InterfaceC1241ba f13019a = c();

    /* renamed from: b */
    private static final InterfaceC1241ba f13020b = new C1243ca();

    public static InterfaceC1241ba a() {
        return f13019a;
    }

    public static InterfaceC1241ba b() {
        return f13020b;
    }

    private static InterfaceC1241ba c() {
        try {
            return (InterfaceC1241ba) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
