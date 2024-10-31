package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzaji extends zzbcr<zzajr> {
    private final Object mLock = new Object();
    private final zzajm zzdjp;
    private boolean zzdjq;

    public zzaji(zzajm zzajmVar) {
        this.zzdjp = zzajmVar;
    }

    public final void release() {
        synchronized (this.mLock) {
            if (this.zzdjq) {
                return;
            }
            this.zzdjq = true;
            zza(new Ta(this), new zzbcp());
            zza(new Ua(this), new Va(this));
        }
    }
}
