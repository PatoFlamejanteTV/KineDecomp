package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.internal.zzcj;

@zzgr
/* loaded from: classes.dex */
public final class zzch extends zzcj.zza {
    private final com.google.android.gms.ads.internal.zzg zzvW;
    private final String zzvX;
    private final String zzvY;

    public zzch(com.google.android.gms.ads.internal.zzg zzgVar, String str, String str2) {
        this.zzvW = zzgVar;
        this.zzvX = str;
        this.zzvY = str2;
    }

    @Override // com.google.android.gms.internal.zzcj
    public String getContent() {
        return this.zzvY;
    }

    @Override // com.google.android.gms.internal.zzcj
    public void recordClick() {
        this.zzvW.a();
    }

    @Override // com.google.android.gms.internal.zzcj
    public void recordImpression() {
        this.zzvW.recordImpression();
    }

    @Override // com.google.android.gms.internal.zzcj
    public void zza(com.google.android.gms.dynamic.zzd zzdVar) {
        if (zzdVar == null) {
            return;
        }
        this.zzvW.a((View) com.google.android.gms.dynamic.zze.a(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzcj
    public String zzdr() {
        return this.zzvX;
    }
}
