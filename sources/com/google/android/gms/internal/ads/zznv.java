package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
public final class zznv extends zznu {
    final List<zzno> zzbdz;

    public zznv(zzno zznoVar, long j, long j2, int i, long j3, List<zznx> list, List<zzno> list2) {
        super(zznoVar, j, j2, i, j3, list);
        this.zzbdz = list2;
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final zzno zza(zznp zznpVar, int i) {
        return this.zzbdz.get(i - this.zzbdx);
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final int zzai(long j) {
        return this.zzbdz.size();
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final boolean zzge() {
        return true;
    }
}
