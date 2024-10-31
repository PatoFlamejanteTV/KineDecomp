package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.internal.zzcw;

@zzgr
/* loaded from: classes.dex */
public class zzdb extends zzcw.zza {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzxj;

    public zzdb(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzxj = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzcw
    public void zza(zzcq zzcqVar) {
        this.zzxj.a(zzb(zzcqVar));
    }

    zzcr zzb(zzcq zzcqVar) {
        return new zzcr(zzcqVar);
    }
}
