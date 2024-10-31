package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.clearcut.ga, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1200ga<T> implements InterfaceC1218pa<T> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdo f12837a;

    /* renamed from: b, reason: collision with root package name */
    private final Ga<?, ?> f12838b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f12839c;

    /* renamed from: d, reason: collision with root package name */
    private final B<?> f12840d;

    private C1200ga(Ga<?, ?> ga, B<?> b2, zzdo zzdoVar) {
        this.f12838b = ga;
        this.f12839c = b2.a(zzdoVar);
        this.f12840d = b2;
        this.f12837a = zzdoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> C1200ga<T> a(Ga<?, ?> ga, B<?> b2, zzdo zzdoVar) {
        return new C1200ga<>(ga, b2, zzdoVar);
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    public final int a(T t) {
        int hashCode = this.f12838b.c(t).hashCode();
        return this.f12839c ? (hashCode * 53) + this.f12840d.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    public final void a(T t, Sa sa) throws IOException {
        int zzc;
        Object value;
        Iterator<Map.Entry<?, Object>> e2 = this.f12840d.a(t).e();
        while (e2.hasNext()) {
            Map.Entry<?, Object> next = e2.next();
            zzca zzcaVar = (zzca) next.getKey();
            if (zzcaVar.zzav() != zzfq.MESSAGE || zzcaVar.zzaw() || zzcaVar.zzax()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof M) {
                zzc = zzcaVar.zzc();
                value = ((M) next).a().zzr();
            } else {
                zzc = zzcaVar.zzc();
                value = next.getValue();
            }
            sa.zza(zzc, value);
        }
        Ga<?, ?> ga = this.f12838b;
        ga.b((Ga<?, ?>) ga.c(t), sa);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[EDGE_INSN: B:24:0x0061->B:25:0x0061 BREAK  A[LOOP:1: B:10:0x0032->B:18:0x0032], SYNTHETIC] */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r8, byte[] r9, int r10, int r11, com.google.android.gms.internal.clearcut.C1215o r12) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.clearcut.zzcg r8 = (com.google.android.gms.internal.clearcut.zzcg) r8
            com.google.android.gms.internal.clearcut.zzey r0 = r8.zzjp
            com.google.android.gms.internal.clearcut.zzey r1 = com.google.android.gms.internal.clearcut.zzey.zzea()
            if (r0 != r1) goto L10
            com.google.android.gms.internal.clearcut.zzey r0 = com.google.android.gms.internal.clearcut.zzey.zzeb()
            r8.zzjp = r0
        L10:
            r8 = r0
        L11:
            if (r10 >= r11) goto L6b
            int r2 = com.google.android.gms.internal.clearcut.C1213n.a(r9, r10, r12)
            int r0 = r12.f12869a
            r10 = 11
            r1 = 2
            if (r0 == r10) goto L30
            r10 = r0 & 7
            if (r10 != r1) goto L2b
            r1 = r9
            r3 = r11
            r4 = r8
            r5 = r12
            int r10 = com.google.android.gms.internal.clearcut.C1213n.a(r0, r1, r2, r3, r4, r5)
            goto L11
        L2b:
            int r10 = com.google.android.gms.internal.clearcut.C1213n.a(r0, r9, r2, r11, r12)
            goto L11
        L30:
            r10 = 0
            r0 = 0
        L32:
            if (r2 >= r11) goto L61
            int r2 = com.google.android.gms.internal.clearcut.C1213n.a(r9, r2, r12)
            int r3 = r12.f12869a
            int r4 = r3 >>> 3
            r5 = r3 & 7
            if (r4 == r1) goto L4f
            r6 = 3
            if (r4 == r6) goto L44
            goto L58
        L44:
            if (r5 != r1) goto L58
            int r2 = com.google.android.gms.internal.clearcut.C1213n.e(r9, r2, r12)
            java.lang.Object r0 = r12.f12871c
            com.google.android.gms.internal.clearcut.zzbb r0 = (com.google.android.gms.internal.clearcut.zzbb) r0
            goto L32
        L4f:
            if (r5 != 0) goto L58
            int r2 = com.google.android.gms.internal.clearcut.C1213n.a(r9, r2, r12)
            int r10 = r12.f12869a
            goto L32
        L58:
            r4 = 12
            if (r3 == r4) goto L61
            int r2 = com.google.android.gms.internal.clearcut.C1213n.a(r3, r9, r2, r11, r12)
            goto L32
        L61:
            if (r0 == 0) goto L69
            int r10 = r10 << 3
            r10 = r10 | r1
            r8.zzb(r10, r0)
        L69:
            r10 = r2
            goto L11
        L6b:
            if (r10 != r11) goto L6e
            return
        L6e:
            com.google.android.gms.internal.clearcut.zzco r8 = com.google.android.gms.internal.clearcut.zzco.zzbo()
            goto L74
        L73:
            throw r8
        L74:
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1200ga.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.o):void");
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    public final boolean a(T t, T t2) {
        if (!this.f12838b.c(t).equals(this.f12838b.c(t2))) {
            return false;
        }
        if (this.f12839c) {
            return this.f12840d.a(t).equals(this.f12840d.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    public final int b(T t) {
        Ga<?, ?> ga = this.f12838b;
        int d2 = ga.d(ga.c(t)) + 0;
        return this.f12839c ? d2 + this.f12840d.a(t).h() : d2;
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    public final void b(T t, T t2) {
        C1221ra.a(this.f12838b, t, t2);
        if (this.f12839c) {
            C1221ra.a(this.f12840d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    public final void c(T t) {
        this.f12838b.a(t);
        this.f12840d.c(t);
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    public final T newInstance() {
        return (T) this.f12837a.zzbd().zzbi();
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    public final boolean zzo(T t) {
        return this.f12840d.a(t).d();
    }
}
