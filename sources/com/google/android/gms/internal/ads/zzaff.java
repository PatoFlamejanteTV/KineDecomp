package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

@zzark
/* loaded from: classes2.dex */
public final class zzaff extends zzael {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzdek;

    public zzaff(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzdek = onCustomTemplateAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaek
    public final void zzb(zzadx zzadxVar) {
        this.zzdek.a(zzaea.zza(zzadxVar));
    }
}
