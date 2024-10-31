package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class Sa<T> implements _a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final zzsk f13179a;

    /* renamed from: b, reason: collision with root package name */
    private final qb<?, ?> f13180b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f13181c;

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC1325pa<?> f13182d;

    private Sa(qb<?, ?> qbVar, AbstractC1325pa<?> abstractC1325pa, zzsk zzskVar) {
        this.f13180b = qbVar;
        this.f13181c = abstractC1325pa.a(zzskVar);
        this.f13182d = abstractC1325pa;
        this.f13179a = zzskVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Sa<T> a(qb<?, ?> qbVar, AbstractC1325pa<?> abstractC1325pa, zzsk zzskVar) {
        return new Sa<>(qbVar, abstractC1325pa, zzskVar);
    }

    @Override // com.google.android.gms.internal.gtm._a
    public final void b(T t, T t2) {
        C1294bb.a(this.f13180b, t, t2);
        if (this.f13181c) {
            C1294bb.a(this.f13182d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.gtm._a
    public final int d(T t) {
        qb<?, ?> qbVar = this.f13180b;
        int e2 = qbVar.e(qbVar.c(t)) + 0;
        return this.f13181c ? e2 + this.f13182d.a(t).g() : e2;
    }

    @Override // com.google.android.gms.internal.gtm._a
    public final void e(T t) {
        this.f13180b.f(t);
        this.f13182d.c(t);
    }

    @Override // com.google.android.gms.internal.gtm._a
    public final T newInstance() {
        return (T) this.f13179a.zzph().zzpl();
    }

    @Override // com.google.android.gms.internal.gtm._a
    public final boolean a(T t, T t2) {
        if (!this.f13180b.c(t).equals(this.f13180b.c(t2))) {
            return false;
        }
        if (this.f13181c) {
            return this.f13182d.a(t).equals(this.f13182d.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm._a
    public final boolean b(T t) {
        return this.f13182d.a(t).c();
    }

    @Override // com.google.android.gms.internal.gtm._a
    public final int a(T t) {
        int hashCode = this.f13180b.c(t).hashCode();
        return this.f13181c ? (hashCode * 53) + this.f13182d.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.gtm._a
    public final void a(T t, Cb cb) throws IOException {
        Iterator<Map.Entry<?, Object>> d2 = this.f13182d.a(t).d();
        while (d2.hasNext()) {
            Map.Entry<?, Object> next = d2.next();
            zzqv zzqvVar = (zzqv) next.getKey();
            if (zzqvVar.zzoy() == zzul.MESSAGE && !zzqvVar.zzoz() && !zzqvVar.zzpa()) {
                if (next instanceof Aa) {
                    cb.zza(zzqvVar.zzc(), ((Aa) next).a().zzmv());
                } else {
                    cb.zza(zzqvVar.zzc(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        qb<?, ?> qbVar = this.f13180b;
        qbVar.b((qb<?, ?>) qbVar.c(t), cb);
    }

    @Override // com.google.android.gms.internal.gtm._a
    public final void a(T t, Za za, zzqp zzqpVar) throws IOException {
        boolean z;
        qb<?, ?> qbVar = this.f13180b;
        AbstractC1325pa<?> abstractC1325pa = this.f13182d;
        Object d2 = qbVar.d(t);
        C1330sa<?> b2 = abstractC1325pa.b(t);
        while (za.m() != Integer.MAX_VALUE) {
            try {
                int tag = za.getTag();
                if (tag == 11) {
                    Object obj = null;
                    zzps zzpsVar = null;
                    int i = 0;
                    while (za.m() != Integer.MAX_VALUE) {
                        int tag2 = za.getTag();
                        if (tag2 == 16) {
                            i = za.g();
                            obj = abstractC1325pa.a(zzqpVar, this.f13179a, i);
                        } else if (tag2 == 26) {
                            if (obj == null) {
                                zzpsVar = za.h();
                            } else {
                                abstractC1325pa.a(za, obj, zzqpVar, b2);
                                throw null;
                            }
                        } else if (!za.k()) {
                            break;
                        }
                    }
                    if (za.getTag() != 12) {
                        throw zzrk.zzps();
                    }
                    if (zzpsVar != null) {
                        if (obj == null) {
                            qbVar.a((qb<?, ?>) d2, i, zzpsVar);
                        } else {
                            abstractC1325pa.a(zzpsVar, obj, zzqpVar, b2);
                            throw null;
                        }
                    }
                    z = true;
                } else if ((tag & 7) == 2) {
                    Object a2 = abstractC1325pa.a(zzqpVar, this.f13179a, tag >>> 3);
                    if (a2 == null) {
                        z = qbVar.a((qb<?, ?>) d2, za);
                    } else {
                        abstractC1325pa.a(za, a2, zzqpVar, b2);
                        throw null;
                    }
                } else {
                    z = za.k();
                }
                if (!z) {
                    return;
                }
            } finally {
                qbVar.b((Object) t, (T) d2);
            }
        }
    }
}
