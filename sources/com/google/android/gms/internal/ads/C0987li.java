package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.li, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0987li<T> implements InterfaceC1112ui<T> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbsl f12300a;

    /* renamed from: b, reason: collision with root package name */
    private final Li<?, ?> f12301b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f12302c;

    /* renamed from: d, reason: collision with root package name */
    private final Jh<?> f12303d;

    private C0987li(Li<?, ?> li, Jh<?> jh, zzbsl zzbslVar) {
        this.f12301b = li;
        this.f12302c = jh.a(zzbslVar);
        this.f12303d = jh;
        this.f12300a = zzbslVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> C0987li<T> a(Li<?, ?> li, Jh<?> jh, zzbsl zzbslVar) {
        return new C0987li<>(li, jh, zzbslVar);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final void b(T t, T t2) {
        C1140wi.a(this.f12301b, t, t2);
        if (this.f12302c) {
            C1140wi.a(this.f12303d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final int c(T t) {
        Li<?, ?> li = this.f12301b;
        int d2 = li.d(li.b(t)) + 0;
        return this.f12302c ? d2 + this.f12303d.a(t).i() : d2;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final void d(T t) {
        this.f12301b.e(t);
        this.f12303d.c(t);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final T newInstance() {
        return (T) this.f12300a.zzamu().zzamz();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final boolean a(T t, T t2) {
        if (!this.f12301b.b(t).equals(this.f12301b.b(t2))) {
            return false;
        }
        if (this.f12302c) {
            return this.f12303d.a(t).equals(this.f12303d.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final boolean b(T t) {
        return this.f12303d.a(t).d();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final int a(T t) {
        int hashCode = this.f12301b.b(t).hashCode();
        return this.f12302c ? (hashCode * 53) + this.f12303d.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final void a(T t, Xi xi) throws IOException {
        Iterator<Map.Entry<?, Object>> e2 = this.f12303d.a(t).e();
        while (e2.hasNext()) {
            Map.Entry<?, Object> next = e2.next();
            zzbqw zzbqwVar = (zzbqw) next.getKey();
            if (zzbqwVar.zzamm() == zzbuo.MESSAGE && !zzbqwVar.zzamn() && !zzbqwVar.zzamo()) {
                if (next instanceof Uh) {
                    xi.a(zzbqwVar.zzom(), (Object) ((Uh) next).a().zzakf());
                } else {
                    xi.a(zzbqwVar.zzom(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        Li<?, ?> li = this.f12301b;
        li.b((Li<?, ?>) li.b(t), xi);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[EDGE_INSN: B:24:0x0061->B:25:0x0061 BREAK  A[LOOP:1: B:10:0x0032->B:18:0x0032], SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r8, byte[] r9, int r10, int r11, com.google.android.gms.internal.ads.C1111uh r12) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbrd r8 = (com.google.android.gms.internal.ads.zzbrd) r8
            com.google.android.gms.internal.ads.zzbtv r0 = r8.zzfpu
            com.google.android.gms.internal.ads.zzbtv r1 = com.google.android.gms.internal.ads.zzbtv.zzaoz()
            if (r0 != r1) goto L10
            com.google.android.gms.internal.ads.zzbtv r0 = com.google.android.gms.internal.ads.zzbtv.zzapa()
            r8.zzfpu = r0
        L10:
            r8 = r0
        L11:
            if (r10 >= r11) goto L6b
            int r2 = com.google.android.gms.internal.ads.C1097th.a(r9, r10, r12)
            int r0 = r12.f12581a
            r10 = 11
            r1 = 2
            if (r0 == r10) goto L30
            r10 = r0 & 7
            if (r10 != r1) goto L2b
            r1 = r9
            r3 = r11
            r4 = r8
            r5 = r12
            int r10 = com.google.android.gms.internal.ads.C1097th.a(r0, r1, r2, r3, r4, r5)
            goto L11
        L2b:
            int r10 = com.google.android.gms.internal.ads.C1097th.a(r0, r9, r2, r11, r12)
            goto L11
        L30:
            r10 = 0
            r0 = 0
        L32:
            if (r2 >= r11) goto L61
            int r2 = com.google.android.gms.internal.ads.C1097th.a(r9, r2, r12)
            int r3 = r12.f12581a
            int r4 = r3 >>> 3
            r5 = r3 & 7
            if (r4 == r1) goto L4f
            r6 = 3
            if (r4 == r6) goto L44
            goto L58
        L44:
            if (r5 != r1) goto L58
            int r2 = com.google.android.gms.internal.ads.C1097th.e(r9, r2, r12)
            java.lang.Object r0 = r12.f12583c
            com.google.android.gms.internal.ads.zzbpu r0 = (com.google.android.gms.internal.ads.zzbpu) r0
            goto L32
        L4f:
            if (r5 != 0) goto L58
            int r2 = com.google.android.gms.internal.ads.C1097th.a(r9, r2, r12)
            int r10 = r12.f12581a
            goto L32
        L58:
            r4 = 12
            if (r3 == r4) goto L61
            int r2 = com.google.android.gms.internal.ads.C1097th.a(r3, r9, r2, r11, r12)
            goto L32
        L61:
            if (r0 == 0) goto L69
            int r10 = r10 << 3
            r10 = r10 | r1
            r8.zzc(r10, r0)
        L69:
            r10 = r2
            goto L11
        L6b:
            if (r10 != r11) goto L6e
            return
        L6e:
            com.google.android.gms.internal.ads.zzbrl r8 = com.google.android.gms.internal.ads.zzbrl.zzanj()
            goto L74
        L73:
            throw r8
        L74:
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C0987li.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.uh):void");
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final void a(T t, InterfaceC1098ti interfaceC1098ti, zzbqq zzbqqVar) throws IOException {
        boolean z;
        Li<?, ?> li = this.f12301b;
        Jh<?> jh = this.f12303d;
        Object c2 = li.c(t);
        Mh<?> b2 = jh.b(t);
        while (interfaceC1098ti.m() != Integer.MAX_VALUE) {
            try {
                int tag = interfaceC1098ti.getTag();
                if (tag == 11) {
                    Object obj = null;
                    zzbpu zzbpuVar = null;
                    int i = 0;
                    while (interfaceC1098ti.m() != Integer.MAX_VALUE) {
                        int tag2 = interfaceC1098ti.getTag();
                        if (tag2 == 16) {
                            i = interfaceC1098ti.h();
                            obj = jh.a(zzbqqVar, this.f12300a, i);
                        } else if (tag2 == 26) {
                            if (obj == null) {
                                zzbpuVar = interfaceC1098ti.p();
                            } else {
                                jh.a(interfaceC1098ti, obj, zzbqqVar, b2);
                                throw null;
                            }
                        } else if (!interfaceC1098ti.o()) {
                            break;
                        }
                    }
                    if (interfaceC1098ti.getTag() != 12) {
                        throw zzbrl.zzang();
                    }
                    if (zzbpuVar != null) {
                        if (obj == null) {
                            li.a((Li<?, ?>) c2, i, zzbpuVar);
                        } else {
                            jh.a(zzbpuVar, obj, zzbqqVar, b2);
                            throw null;
                        }
                    }
                    z = true;
                } else if ((tag & 7) == 2) {
                    Object a2 = jh.a(zzbqqVar, this.f12300a, tag >>> 3);
                    if (a2 == null) {
                        z = li.a((Li<?, ?>) c2, interfaceC1098ti);
                    } else {
                        jh.a(interfaceC1098ti, a2, zzbqqVar, b2);
                        throw null;
                    }
                } else {
                    z = interfaceC1098ti.o();
                }
                if (!z) {
                    return;
                }
            } finally {
                li.b((Object) t, (T) c2);
            }
        }
    }
}
