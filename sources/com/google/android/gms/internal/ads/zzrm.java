package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class zzrm implements zzsq {
    private final WeakReference<View> zzbvp;
    private final WeakReference<zzaxf> zzbvq;

    public zzrm(View view, zzaxf zzaxfVar) {
        this.zzbvp = new WeakReference<>(view);
        this.zzbvq = new WeakReference<>(zzaxfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final View zznc() {
        return this.zzbvp.get();
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final boolean zznd() {
        return this.zzbvp.get() == null || this.zzbvq.get() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final zzsq zzne() {
        return new zzrl(this.zzbvp.get(), this.zzbvq.get());
    }
}
