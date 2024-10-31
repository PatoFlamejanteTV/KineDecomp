package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.internal.zzcx;

@zzgr
/* loaded from: classes.dex */
public class zzdc extends zzcx.zza {
    private final NativeContentAd.OnContentAdLoadedListener zzxk;

    public zzdc(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzxk = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzcx
    public void zza(zzcs zzcsVar) {
        this.zzxk.a(zzb(zzcsVar));
    }

    zzct zzb(zzcs zzcsVar) {
        return new zzct(zzcsVar);
    }
}
