package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.ai, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0831ai implements InterfaceC1126vi {

    /* renamed from: a, reason: collision with root package name */
    private static final InterfaceC0945ii f12065a = new C0846bi();

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0945ii f12066b;

    public C0831ai() {
        this(new C0861ci(Rh.a(), a()));
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1126vi
    public final <T> InterfaceC1112ui<T> a(Class<T> cls) {
        C1140wi.a((Class<?>) cls);
        InterfaceC0932hi b2 = this.f12066b.b(cls);
        if (b2.a()) {
            if (zzbrd.class.isAssignableFrom(cls)) {
                return C0987li.a(C1140wi.c(), Lh.a(), b2.b());
            }
            return C0987li.a(C1140wi.a(), Lh.b(), b2.b());
        }
        if (zzbrd.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return C0973ki.a(cls, b2, C1029oi.b(), Wh.b(), C1140wi.c(), Lh.a(), C0918gi.b());
            }
            return C0973ki.a(cls, b2, C1029oi.b(), Wh.b(), C1140wi.c(), (Jh<?>) null, C0918gi.b());
        }
        if (a(b2)) {
            return C0973ki.a(cls, b2, C1029oi.a(), Wh.a(), C1140wi.a(), Lh.b(), C0918gi.a());
        }
        return C0973ki.a(cls, b2, C1029oi.a(), Wh.a(), C1140wi.b(), (Jh<?>) null, C0918gi.a());
    }

    private C0831ai(InterfaceC0945ii interfaceC0945ii) {
        zzbrf.zza(interfaceC0945ii, "messageInfoFactory");
        this.f12066b = interfaceC0945ii;
    }

    private static boolean a(InterfaceC0932hi interfaceC0932hi) {
        return interfaceC0932hi.c() == zzbrd.zze.zzfqj;
    }

    private static InterfaceC0945ii a() {
        try {
            return (InterfaceC0945ii) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f12065a;
        }
    }
}
