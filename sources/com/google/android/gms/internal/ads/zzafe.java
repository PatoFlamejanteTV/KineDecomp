package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

@zzark
/* loaded from: classes2.dex */
public final class zzafe extends zzaei {
    private final NativeCustomTemplateAd.OnCustomClickListener zzdej;

    public zzafe(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzdej = onCustomClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final void zzb(zzadx zzadxVar, String str) {
        this.zzdej.a(zzaea.zza(zzadxVar), str);
    }
}
