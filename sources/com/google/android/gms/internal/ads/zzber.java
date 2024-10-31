package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@zzark
/* loaded from: classes2.dex */
public final class zzber implements zzfw {
    private int zzbfz;
    private final zzpa zzevj;
    private long zzevk;
    private long zzevl;
    private long zzevm;
    private long zzevn;
    private boolean zzevo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzber() {
        this(15000, 30000, 2500L, 5000L);
    }

    @VisibleForTesting
    private final void zzh(boolean z) {
        this.zzbfz = 0;
        this.zzevo = false;
        if (z) {
            this.zzevj.reset();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    public final void onStopped() {
        zzh(true);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    public final void zza(zzfz[] zzfzVarArr, zzma zzmaVar, zzoo zzooVar) {
        this.zzbfz = 0;
        for (int i = 0; i < zzfzVarArr.length; i++) {
            if (zzooVar.zzbe(i) != null) {
                this.zzbfz += zzqe.zzbq(zzfzVarArr[i].getTrackType());
            }
        }
        this.zzevj.zzbh(this.zzbfz);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    public final synchronized boolean zzc(long j, boolean z) {
        long j2;
        j2 = z ? this.zzevn : this.zzevm;
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    public final void zzcg() {
        zzh(false);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    public final void zzch() {
        zzh(true);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    public final zzot zzci() {
        return this.zzevj;
    }

    public final synchronized void zzdb(int i) {
        this.zzevm = i * 1000;
    }

    public final synchronized void zzdc(int i) {
        this.zzevn = i * 1000;
    }

    public final synchronized void zzdf(int i) {
        this.zzevk = i * 1000;
    }

    public final synchronized void zzdg(int i) {
        this.zzevl = i * 1000;
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    public final synchronized boolean zzk(long j) {
        boolean z = false;
        char c2 = j > this.zzevl ? (char) 0 : j < this.zzevk ? (char) 2 : (char) 1;
        boolean z2 = this.zzevj.zzgv() >= this.zzbfz;
        if (c2 == 2 || (c2 == 1 && this.zzevo && !z2)) {
            z = true;
        }
        this.zzevo = z;
        return this.zzevo;
    }

    private zzber(int i, int i2, long j, long j2) {
        this.zzevj = new zzpa(true, 65536);
        this.zzevk = 15000000L;
        this.zzevl = 30000000L;
        this.zzevm = 2500000L;
        this.zzevn = 5000000L;
    }
}
