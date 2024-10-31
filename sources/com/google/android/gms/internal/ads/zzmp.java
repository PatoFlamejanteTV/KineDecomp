package com.google.android.gms.internal.ads;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzmp extends zzmc {
    private volatile boolean zzaxq;
    private final zzfs zzazz;
    private volatile int zzbau;
    private volatile boolean zzbav;
    private final int zzwg;

    public zzmp(zzov zzovVar, zzoz zzozVar, zzfs zzfsVar, int i, Object obj, long j, long j2, int i2, int i3, zzfs zzfsVar2) {
        super(zzovVar, zzozVar, zzfsVar, i, obj, j, j2, i2);
        this.zzwg = i3;
        this.zzazz = zzfsVar2;
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
        try {
            long zza = this.zzagy.zza(zzqe.zza(this.zzazo, this.zzbau));
            if (zza != -1) {
                zza += this.zzbau;
            }
            zzhx zzhxVar = new zzhx(this.zzagy, this.zzbau, zza);
            C1171yl zzft = zzft();
            zzft.a(0L);
            zzii zzb = zzft.zzb(0, this.zzwg);
            zzb.zzf(this.zzazz);
            for (int i = 0; i != -1; i = zzb.zza(zzhxVar, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true)) {
                this.zzbau += i;
            }
            zzb.zza(this.zzazs, 1, this.zzbau, 0, null);
            zzqe.zza(this.zzagy);
            this.zzbav = true;
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
    public final boolean zzga() {
        return this.zzbav;
    }
}
