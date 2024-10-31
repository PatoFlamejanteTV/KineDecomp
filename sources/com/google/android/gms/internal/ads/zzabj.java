package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

@zzark
/* loaded from: classes2.dex */
public final class zzabj extends zzabh {
    private final OnCustomRenderedAdLoadedListener zzcmp;

    public zzabj(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcmp = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzabg
    public final void zza(zzabd zzabdVar) {
        this.zzcmp.a(new zzabc(zzabdVar));
    }
}
