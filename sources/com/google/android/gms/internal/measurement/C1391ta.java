package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.ta */
/* loaded from: classes2.dex */
final class C1391ta {

    /* renamed from: a */
    private static final AbstractC1387ra<?> f13523a = new C1389sa();

    /* renamed from: b */
    private static final AbstractC1387ra<?> f13524b = c();

    public static AbstractC1387ra<?> a() {
        return f13523a;
    }

    public static AbstractC1387ra<?> b() {
        AbstractC1387ra<?> abstractC1387ra = f13524b;
        if (abstractC1387ra != null) {
            return abstractC1387ra;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static AbstractC1387ra<?> c() {
        try {
            return (AbstractC1387ra) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
