package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class O implements InterfaceC1265na {

    /* renamed from: a, reason: collision with root package name */
    private static final X f12988a = new P();

    /* renamed from: b, reason: collision with root package name */
    private final X f12989b;

    public O() {
        this(new Q(E.a(), a()));
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1265na
    public final <T> InterfaceC1263ma<T> a(Class<T> cls) {
        C1267oa.a((Class<?>) cls);
        W b2 = this.f12989b.b(cls);
        if (b2.a()) {
            if (zzft.class.isAssignableFrom(cls)) {
                return C1239aa.a(C1267oa.c(), C1285y.a(), b2.b());
            }
            return C1239aa.a(C1267oa.a(), C1285y.b(), b2.b());
        }
        if (zzft.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return Z.a(cls, b2, C1245da.b(), J.b(), C1267oa.c(), C1285y.a(), V.b());
            }
            return Z.a(cls, b2, C1245da.b(), J.b(), C1267oa.c(), null, V.b());
        }
        if (a(b2)) {
            return Z.a(cls, b2, C1245da.a(), J.a(), C1267oa.a(), C1285y.b(), V.a());
        }
        return Z.a(cls, b2, C1245da.a(), J.a(), C1267oa.b(), null, V.a());
    }

    private O(X x) {
        zzfv.zza(x, "messageInfoFactory");
        this.f12989b = x;
    }

    private static boolean a(W w) {
        return w.zzin() == zzft.zze.zzxn;
    }

    private static X a() {
        try {
            return (X) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f12988a;
        }
    }
}
