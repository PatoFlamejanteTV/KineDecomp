package com.google.android.gms.internal;

import java.util.concurrent.Future;

@zzgr
/* loaded from: classes.dex */
public abstract class zzhz implements zzgh<Future> {
    private volatile Thread zzIl;
    private boolean zzIm;
    private final Runnable zzx;

    public zzhz() {
        this.zzx = new dk(this);
        this.zzIm = false;
    }

    public zzhz(boolean z) {
        this.zzx = new dk(this);
        this.zzIm = z;
    }

    @Override // com.google.android.gms.internal.zzgh
    public final void cancel() {
        onStop();
        if (this.zzIl != null) {
            this.zzIl.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzbn();

    @Override // com.google.android.gms.internal.zzgh
    /* renamed from: zzgz, reason: merged with bridge method [inline-methods] */
    public final Future zzfu() {
        return this.zzIm ? zzic.zza(1, this.zzx) : zzic.zza(this.zzx);
    }
}
