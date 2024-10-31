package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ci */
/* loaded from: classes2.dex */
final class C0861ci implements InterfaceC0945ii {

    /* renamed from: a */
    private InterfaceC0945ii[] f12105a;

    public C0861ci(InterfaceC0945ii... interfaceC0945iiArr) {
        this.f12105a = interfaceC0945iiArr;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0945ii
    public final boolean a(Class<?> cls) {
        for (InterfaceC0945ii interfaceC0945ii : this.f12105a) {
            if (interfaceC0945ii.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0945ii
    public final InterfaceC0932hi b(Class<?> cls) {
        for (InterfaceC0945ii interfaceC0945ii : this.f12105a) {
            if (interfaceC0945ii.a(cls)) {
                return interfaceC0945ii.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
