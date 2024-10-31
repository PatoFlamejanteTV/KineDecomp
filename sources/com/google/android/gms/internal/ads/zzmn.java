package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzmn extends zzme {
    private volatile boolean zzaxq;
    private final zzmf zzbat;
    private volatile int zzbau;

    public zzmn(zzov zzovVar, zzoz zzozVar, zzfs zzfsVar, int i, Object obj, zzmf zzmfVar) {
        super(zzovVar, zzozVar, 2, zzfsVar, i, obj, -9223372036854775807L, -9223372036854775807L);
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
                this.zzbat.zza((zzmh) null);
            }
            try {
                zzhz zzhzVar = this.zzbat.zzaxu;
                int i = 0;
                while (i == 0 && !this.zzaxq) {
                    i = zzhzVar.zza(zzhxVar, null);
                }
                boolean z = true;
                if (i == 1) {
                    z = false;
                }
                zzpo.checkState(z);
            } finally {
                this.zzbau = (int) (zzhxVar.getPosition() - this.zzazo.zzbfu);
            }
        } finally {
            zzqe.zza(this.zzagy);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final long zzfv() {
        return this.zzbau;
    }
}
