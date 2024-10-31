package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

@zzark
/* loaded from: classes2.dex */
public final class zzasl extends zzasu {
    private final WeakReference<zzasa> zzdya;

    public zzasl(zzasa zzasaVar) {
        this.zzdya = new WeakReference<>(zzasaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zza(zzasm zzasmVar) {
        zzasa zzasaVar = this.zzdya.get();
        if (zzasaVar != null) {
            zzasaVar.zza(zzasmVar);
        }
    }
}
