package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

@zzark
/* loaded from: classes2.dex */
public final class zzafd extends zzaef {
    private final NativeContentAd.OnContentAdLoadedListener zzdei;

    public zzafd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzdei = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final void zza(zzadt zzadtVar) {
        this.zzdei.onContentAdLoaded(new zzadw(zzadtVar));
    }
}
