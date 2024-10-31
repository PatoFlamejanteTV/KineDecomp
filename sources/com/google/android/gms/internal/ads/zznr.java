package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
public final class zznr extends zznp implements zznd {
    private final zznu zzbdq;

    public zznr(String str, long j, zzfs zzfsVar, String str2, zznu zznuVar, List<zznm> list) {
        super(str, -1L, zzfsVar, str2, zznuVar, list);
        this.zzbdq = zznuVar;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final int zzai(long j) {
        return this.zzbdq.zzai(j);
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final long zzaw(int i) {
        return this.zzbdq.zzbc(i);
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final zzno zzax(int i) {
        return this.zzbdq.zza(this, i);
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final long zze(int i, long j) {
        zznu zznuVar = this.zzbdq;
        List<zznx> list = zznuVar.zzbdy;
        if (list != null) {
            return (list.get(i - zznuVar.zzbdx).zzcs * 1000000) / zznuVar.zzcr;
        }
        if (zznuVar.zzai(j) != -1 && i == (zznuVar.zzbdx + r1) - 1) {
            return j - zznuVar.zzbc(i);
        }
        return (zznuVar.zzcs * 1000000) / zznuVar.zzcr;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final int zzf(long j, long j2) {
        zznu zznuVar = this.zzbdq;
        int i = zznuVar.zzbdx;
        int zzai = zznuVar.zzai(j2);
        if (zzai == 0) {
            return i;
        }
        if (zznuVar.zzbdy == null) {
            int i2 = zznuVar.zzbdx + ((int) (j / ((zznuVar.zzcs * 1000000) / zznuVar.zzcr)));
            return i2 < i ? i : zzai == -1 ? i2 : Math.min(i2, (i + zzai) - 1);
        }
        int i3 = (zzai + i) - 1;
        int i4 = i;
        while (i4 <= i3) {
            int i5 = ((i3 - i4) / 2) + i4;
            long zzbc = zznuVar.zzbc(i5);
            if (zzbc < j) {
                i4 = i5 + 1;
            } else {
                if (zzbc <= j) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return i4 == i ? i4 : i3;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final String zzf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final int zzgd() {
        return this.zzbdq.zzbdx;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final boolean zzge() {
        return this.zzbdq.zzge();
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final zzno zzgi() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final zznd zzgj() {
        return this;
    }
}
