package com.google.android.gms.internal.ads;

import android.content.Context;

@zzark
/* loaded from: classes2.dex */
public final class zzawm implements zzaws {
    private zzawt zzegg;

    public zzawm(zzawt zzawtVar) {
        this.zzegg = zzawtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaws
    public final zzawr zza(Context context, zzbbi zzbbiVar, zzasm zzasmVar) {
        zzawo zzawoVar = zzasmVar.zzdyx;
        if (zzawoVar == null) {
            return null;
        }
        return new zzawg(context, zzbbiVar, zzawoVar, zzasmVar.zzbde, this.zzegg);
    }
}
