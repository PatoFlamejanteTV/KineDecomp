package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzmm extends zzmc {
    private volatile boolean zzaxq;
    private final long zzayv;
    private final int zzbas;
    private final zzmf zzbat;
    private volatile int zzbau;
    private volatile boolean zzbav;

    public zzmm(zzov zzovVar, zzoz zzozVar, zzfs zzfsVar, int i, Object obj, long j, long j2, int i2, int i3, long j3, zzmf zzmfVar) {
        super(zzovVar, zzozVar, zzfsVar, i, obj, j, j2, i2);
        this.zzbas = i3;
        this.zzayv = j3;
        this.zzbat = zzmfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void cancelLoad() {
        this.zzaxq = true;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final boolean zzfe() {
        return this.zzaxq;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzff() throws IOException, InterruptedException {
        zzoz zza = zzqe.zza(this.zzazo, this.zzbau);
        try {
            zzhx zzhxVar = new zzhx(this.zzagy, zza.zzbfu, this.zzagy.zza(zza));
            if (this.zzbau == 0) {
                C1171yl zzft = zzft();
                zzft.a(this.zzayv);
                this.zzbat.zza(zzft);
            }
            try {
                zzhz zzhzVar = this.zzbat.zzaxu;
                int i = 0;
                while (i == 0 && !this.zzaxq) {
                    i = zzhzVar.zza(zzhxVar, null);
                }
                zzpo.checkState(i != 1);
                zzqe.zza(this.zzagy);
                this.zzbav = true;
            } finally {
                this.zzbau = (int) (zzhxVar.getPosition() - this.zzazo.zzbfu);
            }
        } catch (Throwable th) {
            zzqe.zza(this.zzagy);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final long zzfv() {
        return this.zzbau;
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final int zzfz() {
        return this.zzbaw + this.zzbas;
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final boolean zzga() {
        return this.zzbav;
    }
}
