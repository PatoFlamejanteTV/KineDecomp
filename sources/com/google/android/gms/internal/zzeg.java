package com.google.android.gms.internal;

import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzeo;

@zzgr
/* loaded from: classes.dex */
public final class zzeg extends zzeo.zza {
    private final Object zzpd = new Object();
    private zzei.zza zzzh;
    private zzef zzzi;

    @Override // com.google.android.gms.internal.zzeo
    public void onAdClicked() {
        synchronized (this.zzpd) {
            if (this.zzzi != null) {
                this.zzzi.zzaX();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzeo
    public void onAdClosed() {
        synchronized (this.zzpd) {
            if (this.zzzi != null) {
                this.zzzi.zzaY();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzeo
    public void onAdFailedToLoad(int i) {
        synchronized (this.zzpd) {
            if (this.zzzh != null) {
                this.zzzh.zzq(i == 3 ? 1 : 2);
                this.zzzh = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzeo
    public void onAdLeftApplication() {
        synchronized (this.zzpd) {
            if (this.zzzi != null) {
                this.zzzi.zzaZ();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzeo
    public void onAdLoaded() {
        synchronized (this.zzpd) {
            if (this.zzzh != null) {
                this.zzzh.zzq(0);
                this.zzzh = null;
            } else {
                if (this.zzzi != null) {
                    this.zzzi.zzbb();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzeo
    public void onAdOpened() {
        synchronized (this.zzpd) {
            if (this.zzzi != null) {
                this.zzzi.zzba();
            }
        }
    }

    public void zza(zzef zzefVar) {
        synchronized (this.zzpd) {
            this.zzzi = zzefVar;
        }
    }

    public void zza(zzei.zza zzaVar) {
        synchronized (this.zzpd) {
            this.zzzh = zzaVar;
        }
    }

    @Override // com.google.android.gms.internal.zzeo
    public void zza(zzep zzepVar) {
        synchronized (this.zzpd) {
            if (this.zzzh != null) {
                this.zzzh.zza(0, zzepVar);
                this.zzzh = null;
            } else {
                if (this.zzzi != null) {
                    this.zzzi.zzbb();
                }
            }
        }
    }
}
