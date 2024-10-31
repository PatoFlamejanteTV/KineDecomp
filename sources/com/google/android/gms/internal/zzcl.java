package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.zzck;

@zzgr
/* loaded from: classes.dex */
public final class zzcl extends zzck.zza {
    private final OnCustomRenderedAdLoadedListener zztK;

    public zzcl(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zztK = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzck
    public void zza(zzcj zzcjVar) {
        this.zztK.a(new zzci(zzcjVar));
    }
}
