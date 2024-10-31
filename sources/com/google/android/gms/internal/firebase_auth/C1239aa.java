package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase_auth.aa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1239aa<T> implements InterfaceC1263ma<T> {

    /* renamed from: a, reason: collision with root package name */
    private final zzhc f13011a;

    /* renamed from: b, reason: collision with root package name */
    private final Fa<?, ?> f13012b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f13013c;

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC1281w<?> f13014d;

    private C1239aa(Fa<?, ?> fa, AbstractC1281w<?> abstractC1281w, zzhc zzhcVar) {
        this.f13012b = fa;
        this.f13013c = abstractC1281w.a(zzhcVar);
        this.f13014d = abstractC1281w;
        this.f13011a = zzhcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> C1239aa<T> a(Fa<?, ?> fa, AbstractC1281w<?> abstractC1281w, zzhc zzhcVar) {
        return new C1239aa<>(fa, abstractC1281w, zzhcVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final void b(T t, T t2) {
        C1267oa.a(this.f13012b, t, t2);
        if (this.f13013c) {
            C1267oa.a(this.f13014d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final int c(T t) {
        Fa<?, ?> fa = this.f13012b;
        int f2 = fa.f(fa.d(t)) + 0;
        return this.f13013c ? f2 + this.f13014d.a(t).i() : f2;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final T newInstance() {
        return (T) this.f13011a.zzhh().zzhm();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final void zzf(T t) {
        this.f13012b.a(t);
        this.f13014d.c(t);
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final boolean a(T t, T t2) {
        if (!this.f13012b.d(t).equals(this.f13012b.d(t2))) {
            return false;
        }
        if (this.f13013c) {
            return this.f13014d.a(t).equals(this.f13014d.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final boolean b(T t) {
        return this.f13014d.a(t).d();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final int a(T t) {
        int hashCode = this.f13012b.d(t).hashCode();
        return this.f13013c ? (hashCode * 53) + this.f13014d.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final void a(T t, Ra ra) throws IOException {
        Iterator<Map.Entry<?, Object>> e2 = this.f13014d.a(t).e();
        while (e2.hasNext()) {
            Map.Entry<?, Object> next = e2.next();
            zzfm zzfmVar = (zzfm) next.getKey();
            if (zzfmVar.zzgz() == zzjk.MESSAGE && !zzfmVar.zzha() && !zzfmVar.zzhb()) {
                if (next instanceof H) {
                    ra.zza(zzfmVar.zzbi(), ((H) next).a().zzer());
                } else {
                    ra.zza(zzfmVar.zzbi(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        Fa<?, ?> fa = this.f13012b;
        fa.b((Fa<?, ?>) fa.d(t), ra);
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final void a(T t, InterfaceC1255ia interfaceC1255ia, zzfg zzfgVar) throws IOException {
        boolean z;
        Fa<?, ?> fa = this.f13012b;
        AbstractC1281w<?> abstractC1281w = this.f13014d;
        Object e2 = fa.e(t);
        C1287z<?> b2 = abstractC1281w.b(t);
        while (interfaceC1255ia.c() != Integer.MAX_VALUE) {
            try {
                int tag = interfaceC1255ia.getTag();
                if (tag == 11) {
                    Object obj = null;
                    zzeh zzehVar = null;
                    int i = 0;
                    while (interfaceC1255ia.c() != Integer.MAX_VALUE) {
                        int tag2 = interfaceC1255ia.getTag();
                        if (tag2 == 16) {
                            i = interfaceC1255ia.p();
                            obj = abstractC1281w.a(zzfgVar, this.f13011a, i);
                        } else if (tag2 == 26) {
                            if (obj == null) {
                                zzehVar = interfaceC1255ia.n();
                            } else {
                                abstractC1281w.a(interfaceC1255ia, obj, zzfgVar, b2);
                                throw null;
                            }
                        } else if (!interfaceC1255ia.e()) {
                            break;
                        }
                    }
                    if (interfaceC1255ia.getTag() != 12) {
                        throw zzgc.zzhu();
                    }
                    if (zzehVar != null) {
                        if (obj == null) {
                            fa.a((Fa<?, ?>) e2, i, zzehVar);
                        } else {
                            abstractC1281w.a(zzehVar, obj, zzfgVar, b2);
                            throw null;
                        }
                    }
                    z = true;
                } else if ((tag & 7) == 2) {
                    Object a2 = abstractC1281w.a(zzfgVar, this.f13011a, tag >>> 3);
                    if (a2 == null) {
                        z = fa.a((Fa<?, ?>) e2, interfaceC1255ia);
                    } else {
                        abstractC1281w.a(interfaceC1255ia, a2, zzfgVar, b2);
                        throw null;
                    }
                } else {
                    z = interfaceC1255ia.e();
                }
                if (!z) {
                    return;
                }
            } finally {
                fa.b((Object) t, (T) e2);
            }
        }
    }
}
