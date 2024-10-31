package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
final class X implements InterfaceC1194da {

    /* renamed from: a */
    private InterfaceC1194da[] f12818a;

    public X(InterfaceC1194da... interfaceC1194daArr) {
        this.f12818a = interfaceC1194daArr;
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1194da
    public final InterfaceC1192ca a(Class<?> cls) {
        for (InterfaceC1194da interfaceC1194da : this.f12818a) {
            if (interfaceC1194da.b(cls)) {
                return interfaceC1194da.a(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1194da
    public final boolean b(Class<?> cls) {
        for (InterfaceC1194da interfaceC1194da : this.f12818a) {
            if (interfaceC1194da.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
