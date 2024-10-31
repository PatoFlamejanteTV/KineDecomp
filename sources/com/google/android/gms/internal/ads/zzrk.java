package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
public final class zzrk implements zzsq {
    private zzacd zzbvn;

    public zzrk(zzacd zzacdVar) {
        this.zzbvn = zzacdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final View zznc() {
        zzacd zzacdVar = this.zzbvn;
        if (zzacdVar != null) {
            return zzacdVar.zzss();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final boolean zznd() {
        return this.zzbvn == null;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final zzsq zzne() {
        return this;
    }
}
