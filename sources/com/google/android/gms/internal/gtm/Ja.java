package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class Ja implements Pa {

    /* renamed from: a */
    private Pa[] f13161a;

    public Ja(Pa... paArr) {
        this.f13161a = paArr;
    }

    @Override // com.google.android.gms.internal.gtm.Pa
    public final boolean a(Class<?> cls) {
        for (Pa pa : this.f13161a) {
            if (pa.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.Pa
    public final Oa b(Class<?> cls) {
        for (Pa pa : this.f13161a) {
            if (pa.a(cls)) {
                return pa.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
