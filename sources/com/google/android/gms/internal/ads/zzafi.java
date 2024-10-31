package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

@zzark
/* loaded from: classes2.dex */
public final class zzafi extends zzaer {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zzdep;

    public zzafi(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zzdep = onUnifiedNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaeq
    public final void zza(zzaew zzaewVar) {
        this.zzdep.onUnifiedNativeAdLoaded(new zzaez(zzaewVar));
    }
}
