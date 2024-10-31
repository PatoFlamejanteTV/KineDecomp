package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.oi */
/* loaded from: classes2.dex */
final class C1029oi {

    /* renamed from: a */
    private static final InterfaceC1001mi f12388a = c();

    /* renamed from: b */
    private static final InterfaceC1001mi f12389b = new C1015ni();

    public static InterfaceC1001mi a() {
        return f12388a;
    }

    public static InterfaceC1001mi b() {
        return f12389b;
    }

    private static InterfaceC1001mi c() {
        try {
            return (InterfaceC1001mi) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
