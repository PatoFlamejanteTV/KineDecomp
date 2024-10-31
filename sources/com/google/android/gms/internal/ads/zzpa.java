package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzpa implements zzot {
    private final boolean zzbfv;
    private final int zzbfw;
    private final byte[] zzbfx;
    private final zzos[] zzbfy;
    private int zzbfz;
    private int zzbga;
    private int zzbgb;
    private zzos[] zzbgc;

    public zzpa(boolean z, int i) {
        this(true, 65536, 0);
    }

    public final synchronized void reset() {
        if (this.zzbfv) {
            zzbh(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final synchronized void zza(zzos zzosVar) {
        this.zzbfy[0] = zzosVar;
        zza(this.zzbfy);
    }

    public final synchronized void zzbh(int i) {
        boolean z = i < this.zzbfz;
        this.zzbfz = i;
        if (z) {
            zzo();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final synchronized zzos zzgq() {
        zzos zzosVar;
        this.zzbga++;
        if (this.zzbgb > 0) {
            zzos[] zzosVarArr = this.zzbgc;
            int i = this.zzbgb - 1;
            this.zzbgb = i;
            zzosVar = zzosVarArr[i];
            this.zzbgc[this.zzbgb] = null;
        } else {
            zzosVar = new zzos(new byte[this.zzbfw], 0);
        }
        return zzosVar;
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final int zzgr() {
        return this.zzbfw;
    }

    public final synchronized int zzgv() {
        return this.zzbga * this.zzbfw;
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final synchronized void zzo() {
        int max = Math.max(0, zzqe.zzf(this.zzbfz, this.zzbfw) - this.zzbga);
        if (max >= this.zzbgb) {
            return;
        }
        Arrays.fill(this.zzbgc, max, this.zzbgb, (Object) null);
        this.zzbgb = max;
    }

    private zzpa(boolean z, int i, int i2) {
        zzpo.checkArgument(true);
        zzpo.checkArgument(true);
        this.zzbfv = true;
        this.zzbfw = 65536;
        this.zzbgb = 0;
        this.zzbgc = new zzos[100];
        this.zzbfx = null;
        this.zzbfy = new zzos[1];
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final synchronized void zza(zzos[] zzosVarArr) {
        boolean z;
        if (this.zzbgb + zzosVarArr.length >= this.zzbgc.length) {
            this.zzbgc = (zzos[]) Arrays.copyOf(this.zzbgc, Math.max(this.zzbgc.length << 1, this.zzbgb + zzosVarArr.length));
        }
        for (zzos zzosVar : zzosVarArr) {
            if (zzosVar.data != null && zzosVar.data.length != this.zzbfw) {
                z = false;
                zzpo.checkArgument(z);
                zzos[] zzosVarArr2 = this.zzbgc;
                int i = this.zzbgb;
                this.zzbgb = i + 1;
                zzosVarArr2[i] = zzosVar;
            }
            z = true;
            zzpo.checkArgument(z);
            zzos[] zzosVarArr22 = this.zzbgc;
            int i2 = this.zzbgb;
            this.zzbgb = i2 + 1;
            zzosVarArr22[i2] = zzosVar;
        }
        this.zzbga -= zzosVarArr.length;
        notifyAll();
    }
}
