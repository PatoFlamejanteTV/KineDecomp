package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class La implements Ra {

    /* renamed from: a */
    private Ra[] f13381a;

    public La(Ra... raArr) {
        this.f13381a = raArr;
    }

    @Override // com.google.android.gms.internal.measurement.Ra
    public final boolean a(Class<?> cls) {
        for (Ra ra : this.f13381a) {
            if (ra.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.Ra
    public final Qa b(Class<?> cls) {
        for (Ra ra : this.f13381a) {
            if (ra.a(cls)) {
                return ra.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
