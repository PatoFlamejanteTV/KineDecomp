package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzne implements zznd {
    private final zzhw zzbce;

    public zzne(zzhw zzhwVar) {
        this.zzbce = zzhwVar;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final int zzai(long j) {
        return this.zzbce.length;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final long zzaw(int i) {
        return this.zzbce.zzagw[i];
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final zzno zzax(int i) {
        return new zzno(null, this.zzbce.zzagu[i], r0.zzagt[i]);
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final long zze(int i, long j) {
        return this.zzbce.zzagv[i];
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final int zzf(long j, long j2) {
        return this.zzbce.zzq(j);
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final int zzgd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final boolean zzge() {
        return true;
    }
}
