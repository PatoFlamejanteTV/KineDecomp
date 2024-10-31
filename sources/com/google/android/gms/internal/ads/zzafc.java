package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

@zzark
/* loaded from: classes2.dex */
public final class zzafc extends zzaec {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzdeh;

    public zzafc(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzdeh = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final void zza(zzadp zzadpVar) {
        this.zzdeh.onAppInstallAdLoaded(new zzads(zzadpVar));
    }
}
