package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzabb extends zzabe {
    private final com.google.android.gms.ads.internal.zzaf zzczo;
    private final String zzczp;
    private final String zzczq;

    public zzabb(com.google.android.gms.ads.internal.zzaf zzafVar, String str, String str2) {
        this.zzczo = zzafVar;
        this.zzczp = str;
        this.zzczq = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzabd
    public final String getContent() {
        return this.zzczq;
    }

    @Override // com.google.android.gms.internal.ads.zzabd
    public final void recordClick() {
        this.zzczo.x();
    }

    @Override // com.google.android.gms.internal.ads.zzabd
    public final void recordImpression() {
        this.zzczo.y();
    }

    @Override // com.google.android.gms.internal.ads.zzabd
    public final void zzh(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return;
        }
        this.zzczo.a((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzabd
    public final String zzrk() {
        return this.zzczp;
    }
}
