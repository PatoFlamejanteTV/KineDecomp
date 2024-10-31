package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzajm extends zzbcr<zzaii> {
    private zzazn<zzaii> zzdix;
    private final Object mLock = new Object();
    private boolean zzdjs = false;
    private int zzdjt = 0;

    public zzajm(zzazn<zzaii> zzaznVar) {
        this.zzdix = zzaznVar;
    }

    private final void zzug() {
        synchronized (this.mLock) {
            Preconditions.b(this.zzdjt >= 0);
            if (this.zzdjs && this.zzdjt == 0) {
                zzaxz.v("No reference is left (including root). Cleaning up engine.");
                zza(new Ya(this), new zzbcp());
            } else {
                zzaxz.v("There are still references to the engine. Not destroying.");
            }
        }
    }

    public final zzaji zzud() {
        zzaji zzajiVar = new zzaji(this);
        synchronized (this.mLock) {
            zza(new Wa(this, zzajiVar), new Xa(this, zzajiVar));
            Preconditions.b(this.zzdjt >= 0);
            this.zzdjt++;
        }
        return zzajiVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzue() {
        synchronized (this.mLock) {
            Preconditions.b(this.zzdjt > 0);
            zzaxz.v("Releasing 1 reference for JS Engine");
            this.zzdjt--;
            zzug();
        }
    }

    public final void zzuf() {
        synchronized (this.mLock) {
            Preconditions.b(this.zzdjt >= 0);
            zzaxz.v("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzdjs = true;
            zzug();
        }
    }
}
