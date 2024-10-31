package com.google.android.gms.internal.ads;

import android.content.Context;

@zzark
/* loaded from: classes2.dex */
public final class zzasf extends zzasc {
    private final Context mContext;

    public zzasf(Context context, zzbcn<zzasi> zzbcnVar, zzasa zzasaVar) {
        super(zzbcnVar, zzasaVar);
        this.mContext = context;
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final void zzwi() {
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final zzasq zzwj() {
        Context context = this.mContext;
        return zzatq.zza(context, zzatp.zzo(context));
    }
}
