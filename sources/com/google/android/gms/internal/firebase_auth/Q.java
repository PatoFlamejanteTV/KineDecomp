package com.google.android.gms.internal.firebase_auth;

/* loaded from: classes2.dex */
final class Q implements X {

    /* renamed from: a */
    private X[] f12990a;

    public Q(X... xArr) {
        this.f12990a = xArr;
    }

    @Override // com.google.android.gms.internal.firebase_auth.X
    public final boolean a(Class<?> cls) {
        for (X x : this.f12990a) {
            if (x.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.firebase_auth.X
    public final W b(Class<?> cls) {
        for (X x : this.f12990a) {
            if (x.a(cls)) {
                return x.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
