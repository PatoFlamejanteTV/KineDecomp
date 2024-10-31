package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzng implements zzmr {
    private final zzow zzaxv;
    private final int zzbch;

    public zzng(zzow zzowVar) {
        this(zzowVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final zzmq zza(zzpk zzpkVar, zznj zznjVar, int i, int[] iArr, zzom zzomVar, int i2, long j, boolean z, boolean z2) {
        return new zznf(zzpkVar, zznjVar, i, iArr, zzomVar, i2, this.zzaxv.zzgs(), j, this.zzbch, z, z2);
    }

    private zzng(zzow zzowVar, int i) {
        this.zzaxv = zzowVar;
        this.zzbch = 1;
    }
}
