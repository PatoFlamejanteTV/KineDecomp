package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
public final class zznw extends zznu {
    final zzoa zzbea;
    final zzoa zzbeb;

    public zznw(zzno zznoVar, long j, long j2, int i, long j3, List<zznx> list, zzoa zzoaVar, zzoa zzoaVar2) {
        super(zznoVar, j, j2, i, j3, list);
        this.zzbea = zzoaVar;
        this.zzbeb = zzoaVar2;
    }

    @Override // com.google.android.gms.internal.ads.zznt
    public final zzno zza(zznp zznpVar) {
        zzoa zzoaVar = this.zzbea;
        if (zzoaVar != null) {
            zzfs zzfsVar = zznpVar.zzaad;
            return new zzno(zzoaVar.zza(zzfsVar.zzze, 0, zzfsVar.zzzf, 0L), 0L, -1L);
        }
        return super.zza(zznpVar);
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final int zzai(long j) {
        List<zznx> list = this.zzbdy;
        if (list != null) {
            return list.size();
        }
        if (j != -9223372036854775807L) {
            return (int) zzqe.zzg(j, (this.zzcs * 1000000) / this.zzcr);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final zzno zza(zznp zznpVar, int i) {
        long j;
        List<zznx> list = this.zzbdy;
        if (list != null) {
            j = list.get(i - this.zzbdx).startTime;
        } else {
            j = (i - this.zzbdx) * this.zzcs;
        }
        long j2 = j;
        zzoa zzoaVar = this.zzbeb;
        zzfs zzfsVar = zznpVar.zzaad;
        return new zzno(zzoaVar.zza(zzfsVar.zzze, i, zzfsVar.zzzf, j2), 0L, -1L);
    }
}
