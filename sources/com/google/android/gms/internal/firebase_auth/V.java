package com.google.android.gms.internal.firebase_auth;

/* loaded from: classes2.dex */
final class V {

    /* renamed from: a */
    private static final T f12996a = c();

    /* renamed from: b */
    private static final T f12997b = new U();

    public static T a() {
        return f12996a;
    }

    public static T b() {
        return f12997b;
    }

    private static T c() {
        try {
            return (T) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
