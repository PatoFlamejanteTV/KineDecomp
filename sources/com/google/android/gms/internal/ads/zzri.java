package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class zzri implements zzsq {
    private WeakReference<zzacd> zzbvm;

    public zzri(zzacd zzacdVar) {
        this.zzbvm = new WeakReference<>(zzacdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final View zznc() {
        zzacd zzacdVar = this.zzbvm.get();
        if (zzacdVar != null) {
            return zzacdVar.zzss();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final boolean zznd() {
        return this.zzbvm.get() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final zzsq zzne() {
        return new zzrk(this.zzbvm.get());
    }
}
