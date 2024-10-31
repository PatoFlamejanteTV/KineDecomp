package com.google.android.gms.internal.ads;

@zzark
/* loaded from: classes2.dex */
public abstract class zzaxv implements zzazb<zzbcb> {
    private volatile Thread zzeke;
    private final Runnable zzy = new RunnableC1079sd(this);
    private boolean zzekf = false;

    public zzaxv() {
    }

    @Override // com.google.android.gms.internal.ads.zzazb
    public final void cancel() {
        onStop();
        if (this.zzeke != null) {
            this.zzeke.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzki();

    @Override // com.google.android.gms.internal.ads.zzazb
    public final /* synthetic */ zzbcb zzwa() {
        if (this.zzekf) {
            return zzayf.zzekz.submit(this.zzy);
        }
        return zzayf.zzc(this.zzy);
    }

    public final zzbcb zzyz() {
        if (this.zzekf) {
            return zzayf.zzekz.submit(this.zzy);
        }
        return zzayf.zzc(this.zzy);
    }

    public zzaxv(boolean z) {
    }
}
