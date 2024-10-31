package com.google.android.gms.internal.clearcut;

/* renamed from: com.google.android.gms.internal.clearcut.ba */
/* loaded from: classes2.dex */
final class C1190ba {

    /* renamed from: a */
    private static final Z f12824a = c();

    /* renamed from: b */
    private static final Z f12825b = new C1188aa();

    public static Z a() {
        return f12824a;
    }

    public static Z b() {
        return f12825b;
    }

    private static Z c() {
        try {
            return (Z) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
