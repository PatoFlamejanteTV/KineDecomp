package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class Va {

    /* renamed from: a */
    private static final Ta f13187a = c();

    /* renamed from: b */
    private static final Ta f13188b = new Ua();

    public static Ta a() {
        return f13187a;
    }

    public static Ta b() {
        return f13188b;
    }

    private static Ta c() {
        try {
            return (Ta) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
