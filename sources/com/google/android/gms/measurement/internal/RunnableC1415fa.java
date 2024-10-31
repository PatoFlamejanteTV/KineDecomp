package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.fa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1415fa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f13761a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzdx f13762b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzdx f13763c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzdy f13764d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1415fa(zzdy zzdyVar, boolean z, zzdx zzdxVar, zzdx zzdxVar2) {
        this.f13764d = zzdyVar;
        this.f13761a = z;
        this.f13762b = zzdxVar;
        this.f13763c = zzdxVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:            if (com.google.android.gms.measurement.internal.zzfy.d(r10.f13762b.f14008a, r10.f13763c.f14008a) != false) goto L27;     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r10 = this;
            com.google.android.gms.measurement.internal.zzdy r0 = r10.f13764d
            com.google.android.gms.measurement.internal.zzq r0 = r0.j()
            com.google.android.gms.measurement.internal.zzdy r1 = r10.f13764d
            com.google.android.gms.measurement.internal.zzam r1 = r1.n()
            java.lang.String r1 = r1.z()
            boolean r0 = r0.s(r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L2f
            boolean r0 = r10.f13761a
            if (r0 == 0) goto L24
            com.google.android.gms.measurement.internal.zzdy r0 = r10.f13764d
            com.google.android.gms.measurement.internal.zzdx r0 = r0.f14012c
            if (r0 == 0) goto L24
            r0 = 1
            goto L25
        L24:
            r0 = 0
        L25:
            if (r0 == 0) goto L3d
            com.google.android.gms.measurement.internal.zzdy r3 = r10.f13764d
            com.google.android.gms.measurement.internal.zzdx r4 = r3.f14012c
            com.google.android.gms.measurement.internal.zzdy.a(r3, r4, r2)
            goto L3d
        L2f:
            boolean r0 = r10.f13761a
            if (r0 == 0) goto L3c
            com.google.android.gms.measurement.internal.zzdy r0 = r10.f13764d
            com.google.android.gms.measurement.internal.zzdx r3 = r0.f14012c
            if (r3 == 0) goto L3c
            com.google.android.gms.measurement.internal.zzdy.a(r0, r3, r2)
        L3c:
            r0 = 0
        L3d:
            com.google.android.gms.measurement.internal.zzdx r3 = r10.f13762b
            if (r3 == 0) goto L63
            long r4 = r3.f14010c
            com.google.android.gms.measurement.internal.zzdx r6 = r10.f13763c
            long r7 = r6.f14010c
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 != 0) goto L63
            java.lang.String r3 = r3.f14009b
            java.lang.String r4 = r6.f14009b
            boolean r3 = com.google.android.gms.measurement.internal.zzfy.d(r3, r4)
            if (r3 == 0) goto L63
            com.google.android.gms.measurement.internal.zzdx r3 = r10.f13762b
            java.lang.String r3 = r3.f14008a
            com.google.android.gms.measurement.internal.zzdx r4 = r10.f13763c
            java.lang.String r4 = r4.f14008a
            boolean r3 = com.google.android.gms.measurement.internal.zzfy.d(r3, r4)
            if (r3 != 0) goto L64
        L63:
            r1 = 1
        L64:
            if (r1 == 0) goto Lcd
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            com.google.android.gms.measurement.internal.zzdx r3 = r10.f13763c
            com.google.android.gms.measurement.internal.zzdy.a(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzdx r2 = r10.f13762b
            if (r2 == 0) goto L8f
            java.lang.String r2 = r2.f14008a
            if (r2 == 0) goto L7d
            java.lang.String r3 = "_pn"
            r1.putString(r3, r2)
        L7d:
            com.google.android.gms.measurement.internal.zzdx r2 = r10.f13762b
            java.lang.String r2 = r2.f14009b
            java.lang.String r3 = "_pc"
            r1.putString(r3, r2)
            com.google.android.gms.measurement.internal.zzdx r2 = r10.f13762b
            long r2 = r2.f14010c
            java.lang.String r4 = "_pi"
            r1.putLong(r4, r2)
        L8f:
            com.google.android.gms.measurement.internal.zzdy r2 = r10.f13764d
            com.google.android.gms.measurement.internal.zzq r2 = r2.j()
            com.google.android.gms.measurement.internal.zzdy r3 = r10.f13764d
            com.google.android.gms.measurement.internal.zzam r3 = r3.n()
            java.lang.String r3 = r3.z()
            boolean r2 = r2.s(r3)
            if (r2 == 0) goto Lc0
            if (r0 == 0) goto Lc0
            com.google.android.gms.measurement.internal.zzdy r0 = r10.f13764d
            com.google.android.gms.measurement.internal.zzfd r0 = r0.r()
            long r2 = r0.z()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto Lc0
            com.google.android.gms.measurement.internal.zzdy r0 = r10.f13764d
            com.google.android.gms.measurement.internal.zzfy r0 = r0.h()
            r0.a(r1, r2)
        Lc0:
            com.google.android.gms.measurement.internal.zzdy r0 = r10.f13764d
            com.google.android.gms.measurement.internal.zzda r0 = r0.m()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_vs"
            r0.c(r2, r3, r1)
        Lcd:
            com.google.android.gms.measurement.internal.zzdy r0 = r10.f13764d
            com.google.android.gms.measurement.internal.zzdx r1 = r10.f13763c
            r0.f14012c = r1
            com.google.android.gms.measurement.internal.zzeb r0 = r0.o()
            com.google.android.gms.measurement.internal.zzdx r1 = r10.f13763c
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.RunnableC1415fa.run():void");
    }
}
