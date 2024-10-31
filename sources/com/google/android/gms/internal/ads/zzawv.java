package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

@zzark
/* loaded from: classes2.dex */
public final class zzawv implements zzsg {
    private final Object mLock;
    private String zzboa;
    private final Context zzdvi;
    private boolean zzegs;

    public zzawv(Context context, String str) {
        this.zzdvi = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzboa = str;
        this.zzegs = false;
        this.mLock = new Object();
    }

    public final void setAdUnitId(String str) {
        this.zzboa = str;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(zzsf zzsfVar) {
        zzai(zzsfVar.zzuc);
    }

    public final void zzai(boolean z) {
        if (com.google.android.gms.ads.internal.zzbv.E().zzv(this.zzdvi)) {
            synchronized (this.mLock) {
                if (this.zzegs == z) {
                    return;
                }
                this.zzegs = z;
                if (TextUtils.isEmpty(this.zzboa)) {
                    return;
                }
                if (this.zzegs) {
                    com.google.android.gms.ads.internal.zzbv.E().zzc(this.zzdvi, this.zzboa);
                } else {
                    com.google.android.gms.ads.internal.zzbv.E().zzd(this.zzdvi, this.zzboa);
                }
            }
        }
    }
}
