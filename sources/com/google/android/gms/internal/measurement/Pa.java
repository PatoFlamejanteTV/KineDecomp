package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class Pa {

    /* renamed from: a */
    private static final Na f13386a = c();

    /* renamed from: b */
    private static final Na f13387b = new Oa();

    public static Na a() {
        return f13386a;
    }

    public static Na b() {
        return f13387b;
    }

    private static Na c() {
        try {
            return (Na) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
