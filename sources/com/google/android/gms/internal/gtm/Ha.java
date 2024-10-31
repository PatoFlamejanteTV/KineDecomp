package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ha implements InterfaceC1291ab {

    /* renamed from: a, reason: collision with root package name */
    private static final Pa f13156a = new Ia();

    /* renamed from: b, reason: collision with root package name */
    private final Pa f13157b;

    public Ha() {
        this(new Ja(C1340xa.a(), a()));
    }

    @Override // com.google.android.gms.internal.gtm.InterfaceC1291ab
    public final <T> _a<T> a(Class<T> cls) {
        C1294bb.a((Class<?>) cls);
        Oa b2 = this.f13157b.b(cls);
        if (b2.b()) {
            if (zzrc.class.isAssignableFrom(cls)) {
                return Sa.a(C1294bb.c(), C1328ra.a(), b2.a());
            }
            return Sa.a(C1294bb.a(), C1328ra.b(), b2.a());
        }
        if (zzrc.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return Ra.a(cls, b2, Va.b(), Ca.b(), C1294bb.c(), C1328ra.a(), Na.b());
            }
            return Ra.a(cls, b2, Va.b(), Ca.b(), C1294bb.c(), null, Na.b());
        }
        if (a(b2)) {
            return Ra.a(cls, b2, Va.a(), Ca.a(), C1294bb.a(), C1328ra.b(), Na.a());
        }
        return Ra.a(cls, b2, Va.a(), Ca.a(), C1294bb.b(), null, Na.a());
    }

    private Ha(Pa pa) {
        zzre.zza(pa, "messageInfoFactory");
        this.f13157b = pa;
    }

    private static boolean a(Oa oa) {
        return oa.c() == zzrc.zze.zzbaz;
    }

    private static Pa a() {
        try {
            return (Pa) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f13156a;
        }
    }
}
