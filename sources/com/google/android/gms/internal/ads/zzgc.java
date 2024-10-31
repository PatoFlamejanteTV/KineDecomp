package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public abstract class zzgc {
    public static final zzgc zzaal = new _j();

    private final zzgf zza(int i, zzgf zzgfVar) {
        return zza(i, zzgfVar, false, 0L);
    }

    public final boolean isEmpty() {
        return zzck() == 0;
    }

    public abstract zzge zza(int i, zzge zzgeVar, boolean z);

    public abstract zzgf zza(int i, zzgf zzgfVar, boolean z, long j);

    public abstract int zzc(Object obj);

    public abstract int zzck();

    public abstract int zzcl();

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:            if ((zzck() - 1) == 0) goto L38;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(int r3, com.google.android.gms.internal.ads.zzge r4, com.google.android.gms.internal.ads.zzgf r5, int r6) {
        /*
            r2 = this;
            r0 = 0
            r2.zza(r3, r4, r0)
            com.google.android.gms.internal.ads.zzgf r4 = r2.zza(r0, r5)
            int r4 = r4.zzaav
            r1 = 1
            if (r4 != r3) goto L34
            r3 = -1
            if (r6 == 0) goto L25
            if (r6 == r1) goto L23
            r4 = 2
            if (r6 != r4) goto L1d
            int r4 = r2.zzck()
            int r4 = r4 - r1
            if (r4 != 0) goto L2d
            goto L23
        L1d:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>()
            throw r3
        L23:
            r1 = 0
            goto L2d
        L25:
            int r4 = r2.zzck()
            int r4 = r4 - r1
            if (r4 != 0) goto L2d
            r1 = -1
        L2d:
            if (r1 != r3) goto L30
            return r3
        L30:
            r2.zza(r1, r5)
            return r0
        L34:
            int r3 = r3 + r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgc.zza(int, com.google.android.gms.internal.ads.zzge, com.google.android.gms.internal.ads.zzgf, int):int");
    }
}
