package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.gi */
/* loaded from: classes2.dex */
final class C0918gi {

    /* renamed from: a */
    private static final InterfaceC0890ei f12181a = c();

    /* renamed from: b */
    private static final InterfaceC0890ei f12182b = new C0904fi();

    public static InterfaceC0890ei a() {
        return f12181a;
    }

    public static InterfaceC0890ei b() {
        return f12182b;
    }

    private static InterfaceC0890ei c() {
        try {
            return (InterfaceC0890ei) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
