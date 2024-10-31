package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzly extends zzgc {
    private static final Object zzazd = new Object();
    private final boolean zzaas;
    private final boolean zzaat;
    private final long zzaze;
    private final long zzazf;
    private final long zzazg;
    private final long zzazh;

    public zzly(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzgc
    public final zzgf zza(int i, zzgf zzgfVar, boolean z, long j) {
        zzpo.zzc(i, 0, 1);
        return zzgfVar.zza(null, -9223372036854775807L, -9223372036854775807L, this.zzaas, false, 0L, this.zzazf, 0, 0, 0L);
    }

    @Override // com.google.android.gms.internal.ads.zzgc
    public final int zzc(Object obj) {
        return zzazd.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgc
    public final int zzck() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzgc
    public final int zzcl() {
        return 1;
    }

    private zzly(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.zzaze = j;
        this.zzazf = j2;
        this.zzazg = 0L;
        this.zzazh = 0L;
        this.zzaas = z;
        this.zzaat = false;
    }

    @Override // com.google.android.gms.internal.ads.zzgc
    public final zzge zza(int i, zzge zzgeVar, boolean z) {
        zzpo.zzc(i, 0, 1);
        Object obj = z ? zzazd : null;
        return zzgeVar.zza(obj, obj, 0, this.zzaze, 0L, false);
    }
}
