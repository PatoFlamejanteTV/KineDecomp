package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzmk implements zzlv {
    private final int index;
    public final zzmj<T> zzbap;
    private final zzls zzbaq;
    private final /* synthetic */ zzmj zzbar;

    public zzmk(zzmj zzmjVar, zzmj<T> zzmjVar2, zzls zzlsVar, int i) {
        this.zzbar = zzmjVar;
        this.zzbap = zzmjVar2;
        this.zzbaq = zzlsVar;
        this.index = i;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final boolean isReady() {
        zzmj zzmjVar = this.zzbar;
        if (zzmjVar.zzaxm) {
            return true;
        }
        return !zzmjVar.zzfd() && this.zzbaq.zzfm();
    }

    public final void release() {
        boolean[] zArr;
        boolean[] zArr2;
        zArr = this.zzbar.zzbae;
        zzpo.checkState(zArr[this.index]);
        zArr2 = this.zzbar.zzbae;
        zArr2[this.index] = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final int zzb(zzfu zzfuVar, zzho zzhoVar, boolean z) {
        if (this.zzbar.zzfd()) {
            return -3;
        }
        zzls zzlsVar = this.zzbaq;
        zzmj zzmjVar = this.zzbar;
        return zzlsVar.zza(zzfuVar, zzhoVar, z, zzmjVar.zzaxm, zzmjVar.zzaxj);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzev() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzz(long j) {
        if (this.zzbar.zzaxm && j > this.zzbaq.zzfc()) {
            this.zzbaq.zzfp();
        } else {
            this.zzbaq.zze(j, true);
        }
    }
}
