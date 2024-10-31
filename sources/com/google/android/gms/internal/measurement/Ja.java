package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ja implements InterfaceC1356db {

    /* renamed from: a, reason: collision with root package name */
    private static final Ra f13377a = new Ka();

    /* renamed from: b, reason: collision with root package name */
    private final Ra f13378b;

    public Ja() {
        this(new La(C1403za.a(), a()));
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1356db
    public final <T> InterfaceC1353cb<T> a(Class<T> cls) {
        C1359eb.a((Class<?>) cls);
        Qa b2 = this.f13378b.b(cls);
        if (b2.b()) {
            if (zzuo.class.isAssignableFrom(cls)) {
                return Ua.a(C1359eb.c(), C1391ta.a(), b2.a());
            }
            return Ua.a(C1359eb.a(), C1391ta.b(), b2.a());
        }
        if (zzuo.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return Ta.a(cls, b2, Xa.b(), Ea.b(), C1359eb.c(), C1391ta.a(), Pa.b());
            }
            return Ta.a(cls, b2, Xa.b(), Ea.b(), C1359eb.c(), null, Pa.b());
        }
        if (a(b2)) {
            return Ta.a(cls, b2, Xa.a(), Ea.a(), C1359eb.a(), C1391ta.b(), Pa.a());
        }
        return Ta.a(cls, b2, Xa.a(), Ea.a(), C1359eb.b(), null, Pa.a());
    }

    private Ja(Ra ra) {
        zzuq.zza(ra, "messageInfoFactory");
        this.f13378b = ra;
    }

    private static boolean a(Qa qa) {
        return qa.c() == zzuo.zze.zzbys;
    }

    private static Ra a() {
        try {
            return (Ra) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f13377a;
        }
    }
}
