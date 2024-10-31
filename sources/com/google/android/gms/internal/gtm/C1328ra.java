package com.google.android.gms.internal.gtm;

/* renamed from: com.google.android.gms.internal.gtm.ra */
/* loaded from: classes2.dex */
final class C1328ra {

    /* renamed from: a */
    private static final AbstractC1325pa<?> f13287a = new C1327qa();

    /* renamed from: b */
    private static final AbstractC1325pa<?> f13288b = c();

    public static AbstractC1325pa<?> a() {
        return f13287a;
    }

    public static AbstractC1325pa<?> b() {
        AbstractC1325pa<?> abstractC1325pa = f13288b;
        if (abstractC1325pa != null) {
            return abstractC1325pa;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static AbstractC1325pa<?> c() {
        try {
            return (AbstractC1325pa) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
