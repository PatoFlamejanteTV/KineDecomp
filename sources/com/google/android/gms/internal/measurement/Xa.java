package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class Xa {

    /* renamed from: a */
    private static final Va f13405a = c();

    /* renamed from: b */
    private static final Va f13406b = new Wa();

    public static Va a() {
        return f13405a;
    }

    public static Va b() {
        return f13406b;
    }

    private static Va c() {
        try {
            return (Va) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
