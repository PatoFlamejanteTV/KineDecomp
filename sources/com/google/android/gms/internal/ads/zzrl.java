package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
public final class zzrl implements zzsq {
    private final View mView;
    private final zzaxf zzbvo;

    public zzrl(View view, zzaxf zzaxfVar) {
        this.mView = view;
        this.zzbvo = zzaxfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final View zznc() {
        return this.mView;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final boolean zznd() {
        return this.zzbvo == null || this.mView == null;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final zzsq zzne() {
        return this;
    }
}
