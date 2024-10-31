package com.google.android.gms.internal.clearcut;

/* renamed from: com.google.android.gms.internal.clearcut.ja */
/* loaded from: classes2.dex */
final class C1206ja {

    /* renamed from: a */
    private static final InterfaceC1202ha f12846a = c();

    /* renamed from: b */
    private static final InterfaceC1202ha f12847b = new C1204ia();

    public static InterfaceC1202ha a() {
        return f12846a;
    }

    public static InterfaceC1202ha b() {
        return f12847b;
    }

    private static InterfaceC1202ha c() {
        try {
            return (InterfaceC1202ha) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
