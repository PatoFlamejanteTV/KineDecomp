package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class Ua<T> implements InterfaceC1353cb<T> {

    /* renamed from: a, reason: collision with root package name */
    private final zzvv f13397a;

    /* renamed from: b, reason: collision with root package name */
    private final tb<?, ?> f13398b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f13399c;

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC1387ra<?> f13400d;

    private Ua(tb<?, ?> tbVar, AbstractC1387ra<?> abstractC1387ra, zzvv zzvvVar) {
        this.f13398b = tbVar;
        this.f13399c = abstractC1387ra.a(zzvvVar);
        this.f13400d = abstractC1387ra;
        this.f13397a = zzvvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Ua<T> a(tb<?, ?> tbVar, AbstractC1387ra<?> abstractC1387ra, zzvv zzvvVar) {
        return new Ua<>(tbVar, abstractC1387ra, zzvvVar);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final void b(T t, T t2) {
        C1359eb.a(this.f13398b, t, t2);
        if (this.f13399c) {
            C1359eb.a(this.f13400d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final int c(T t) {
        tb<?, ?> tbVar = this.f13398b;
        int e2 = tbVar.e(tbVar.c(t)) + 0;
        return this.f13399c ? e2 + this.f13400d.a(t).i() : e2;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final boolean d(T t) {
        return this.f13400d.a(t).d();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final T newInstance() {
        return (T) this.f13397a.zzwi().zzwn();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final boolean a(T t, T t2) {
        if (!this.f13398b.c(t).equals(this.f13398b.c(t2))) {
            return false;
        }
        if (this.f13399c) {
            return this.f13400d.a(t).equals(this.f13400d.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final void b(T t) {
        this.f13398b.f(t);
        this.f13400d.c(t);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final int a(T t) {
        int hashCode = this.f13398b.c(t).hashCode();
        return this.f13399c ? (hashCode * 53) + this.f13400d.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final void a(T t, Fb fb) throws IOException {
        Iterator<Map.Entry<?, Object>> e2 = this.f13400d.a(t).e();
        while (e2.hasNext()) {
            Map.Entry<?, Object> next = e2.next();
            zzuh zzuhVar = (zzuh) next.getKey();
            if (zzuhVar.zzwa() == zzxx.MESSAGE && !zzuhVar.zzwb() && !zzuhVar.zzwc()) {
                if (next instanceof Ca) {
                    fb.zza(zzuhVar.zzc(), ((Ca) next).a().zztw());
                } else {
                    fb.zza(zzuhVar.zzc(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        tb<?, ?> tbVar = this.f13398b;
        tbVar.b((tb<?, ?>) tbVar.c(t), fb);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final void a(T t, InterfaceC1350bb interfaceC1350bb, zzub zzubVar) throws IOException {
        boolean z;
        tb<?, ?> tbVar = this.f13398b;
        AbstractC1387ra<?> abstractC1387ra = this.f13400d;
        Object d2 = tbVar.d(t);
        C1393ua<?> b2 = abstractC1387ra.b(t);
        while (interfaceC1350bb.zzvh() != Integer.MAX_VALUE) {
            try {
                int tag = interfaceC1350bb.getTag();
                if (tag == 11) {
                    Object obj = null;
                    zzte zzteVar = null;
                    int i = 0;
                    while (interfaceC1350bb.zzvh() != Integer.MAX_VALUE) {
                        int tag2 = interfaceC1350bb.getTag();
                        if (tag2 == 16) {
                            i = interfaceC1350bb.a();
                            obj = abstractC1387ra.a(zzubVar, this.f13397a, i);
                        } else if (tag2 == 26) {
                            if (obj == null) {
                                zzteVar = interfaceC1350bb.zzur();
                            } else {
                                abstractC1387ra.a(interfaceC1350bb, obj, zzubVar, b2);
                                throw null;
                            }
                        } else if (!interfaceC1350bb.zzvi()) {
                            break;
                        }
                    }
                    if (interfaceC1350bb.getTag() != 12) {
                        throw zzuv.zzwt();
                    }
                    if (zzteVar != null) {
                        if (obj == null) {
                            tbVar.a((tb<?, ?>) d2, i, zzteVar);
                        } else {
                            abstractC1387ra.a(zzteVar, obj, zzubVar, b2);
                            throw null;
                        }
                    }
                    z = true;
                } else if ((tag & 7) == 2) {
                    Object a2 = abstractC1387ra.a(zzubVar, this.f13397a, tag >>> 3);
                    if (a2 == null) {
                        z = tbVar.a((tb<?, ?>) d2, interfaceC1350bb);
                    } else {
                        abstractC1387ra.a(interfaceC1350bb, a2, zzubVar, b2);
                        throw null;
                    }
                } else {
                    z = interfaceC1350bb.zzvi();
                }
                if (!z) {
                    return;
                }
            } finally {
                tbVar.b((Object) t, (T) d2);
            }
        }
    }
}
