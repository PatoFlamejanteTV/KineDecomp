package com.google.android.gms.internal.ads;

import android.content.Context;

@zzark
/* loaded from: classes2.dex */
public class zzapn extends zzapf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapn(Context context, zzaxg zzaxgVar, zzbgg zzbggVar, zzapm zzapmVar) {
        super(context, zzaxgVar, zzbggVar, zzapmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapf
    protected final void zzvz() {
        if (this.zzdsl.errorCode != -2) {
            return;
        }
        this.zzdin.zzadl().zza(this);
        zzwb();
        zzbbd.zzdn("Loading HTML in WebView.");
        zzbgg zzbggVar = this.zzdin;
        zzasm zzasmVar = this.zzdsl;
        zzbggVar.zzc(zzasmVar.zzbde, zzasmVar.zzdyb, null);
    }

    protected void zzwb() {
    }
}
