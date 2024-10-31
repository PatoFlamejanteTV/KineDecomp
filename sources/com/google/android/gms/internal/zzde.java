package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.internal.zzcz;

@zzgr
/* loaded from: classes.dex */
public class zzde extends zzcz.zza {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzxm;

    public zzde(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzxm = onCustomTemplateAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzcz
    public void zza(zzcu zzcuVar) {
        this.zzxm.a(new zzcv(zzcuVar));
    }
}
