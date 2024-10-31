package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzakt extends zzaln {
    private final Object mLock = new Object();
    private zzaky zzdmj;
    private zzaks zzdmk;

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdClicked() {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zziy();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdClosed() {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zziz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdFailedToLoad(int i) {
        synchronized (this.mLock) {
            if (this.zzdmj != null) {
                this.zzdmj.zzco(i == 3 ? 1 : 2);
                this.zzdmj = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdImpression() {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zzjd();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdLeftApplication() {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zzja();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdLoaded() {
        synchronized (this.mLock) {
            if (this.zzdmj != null) {
                this.zzdmj.zzco(0);
                this.zzdmj = null;
            } else {
                if (this.zzdmk != null) {
                    this.zzdmk.zzjc();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdOpened() {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zzjb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAppEvent(String str, String str2) {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zzd(str, str2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onVideoEnd() {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zzix();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onVideoPause() {
    }

    public final void zza(zzaky zzakyVar) {
        synchronized (this.mLock) {
            this.zzdmj = zzakyVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void zzb(zzadx zzadxVar, String str) {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zza(zzadxVar, str);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void zzc(zzawd zzawdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void zzcl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void zzul() {
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void zza(zzalp zzalpVar) {
        synchronized (this.mLock) {
            if (this.zzdmj != null) {
                this.zzdmj.zza(0, zzalpVar);
                this.zzdmj = null;
            } else {
                if (this.zzdmk != null) {
                    this.zzdmk.zzjc();
                }
            }
        }
    }

    public final void zza(zzaks zzaksVar) {
        synchronized (this.mLock) {
            this.zzdmk = zzaksVar;
        }
    }
}
