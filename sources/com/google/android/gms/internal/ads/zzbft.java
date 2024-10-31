package com.google.android.gms.internal.ads;

@zzark
/* loaded from: classes2.dex */
public final class zzbft extends zzbfk {
    public zzbft(zzbdz zzbdzVar) {
        super(zzbdzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void abort() {
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final boolean zzex(String str) {
        zzbdz zzbdzVar = this.zzewo.get();
        if (zzbdzVar != null) {
            zzbdzVar.zza(zzey(str), this);
        }
        zzbbd.zzeo("VideoStreamNoopCache is doing nothing.");
        zza(str, zzey(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
