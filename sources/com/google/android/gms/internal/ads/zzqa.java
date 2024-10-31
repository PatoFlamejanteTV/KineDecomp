package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* loaded from: classes2.dex */
public final class zzqa implements zzps {
    private boolean started;
    private long zzbia;
    private long zzbib;
    private zzfy zzxm = zzfy.zzaaf;

    public final void start() {
        if (this.started) {
            return;
        }
        this.zzbib = SystemClock.elapsedRealtime();
        this.started = true;
    }

    public final void stop() {
        if (this.started) {
            zzam(zzde());
            this.started = false;
        }
    }

    public final void zza(zzps zzpsVar) {
        zzam(zzpsVar.zzde());
        this.zzxm = zzpsVar.zzcx();
    }

    public final void zzam(long j) {
        this.zzbia = j;
        if (this.started) {
            this.zzbib = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final zzfy zzb(zzfy zzfyVar) {
        if (this.started) {
            zzam(zzde());
        }
        this.zzxm = zzfyVar;
        return zzfyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final zzfy zzcx() {
        return this.zzxm;
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final long zzde() {
        long zzl;
        long j = this.zzbia;
        if (!this.started) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzbib;
        zzfy zzfyVar = this.zzxm;
        if (zzfyVar.zzaag == 1.0f) {
            zzl = zzfe.zzg(elapsedRealtime);
        } else {
            zzl = zzfyVar.zzl(elapsedRealtime);
        }
        return j + zzl;
    }
}
