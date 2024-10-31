package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.internal.zzcy;

@zzgr
/* loaded from: classes.dex */
public class zzdd extends zzcy.zza {
    private final NativeCustomTemplateAd.OnCustomClickListener zzxl;

    public zzdd(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzxl = onCustomClickListener;
    }

    @Override // com.google.android.gms.internal.zzcy
    public void zza(zzcu zzcuVar, String str) {
        this.zzxl.a(new zzcv(zzcuVar), str);
    }
}
