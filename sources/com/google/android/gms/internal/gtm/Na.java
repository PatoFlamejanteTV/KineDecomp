package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class Na {

    /* renamed from: a */
    private static final La f13166a = c();

    /* renamed from: b */
    private static final La f13167b = new Ma();

    public static La a() {
        return f13166a;
    }

    public static La b() {
        return f13167b;
    }

    private static La c() {
        try {
            return (La) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
