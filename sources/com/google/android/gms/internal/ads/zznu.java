package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
public abstract class zznu extends zznt {
    final int zzbdx;
    final List<zznx> zzbdy;
    final long zzcs;

    public zznu(zzno zznoVar, long j, long j2, int i, long j3, List<zznx> list) {
        super(zznoVar, j, j2);
        this.zzbdx = i;
        this.zzcs = j3;
        this.zzbdy = list;
    }

    public abstract zzno zza(zznp zznpVar, int i);

    public abstract int zzai(long j);

    public final long zzbc(int i) {
        long j;
        List<zznx> list = this.zzbdy;
        if (list != null) {
            j = list.get(i - this.zzbdx).startTime - this.zzbdw;
        } else {
            j = (i - this.zzbdx) * this.zzcs;
        }
        return zzqe.zza(j, 1000000L, this.zzcr);
    }

    public boolean zzge() {
        return this.zzbdy != null;
    }
}
