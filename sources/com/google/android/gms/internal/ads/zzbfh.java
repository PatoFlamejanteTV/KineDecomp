package com.google.android.gms.internal.ads;

@zzark
/* loaded from: classes2.dex */
public final class zzbfh extends zzaxv {
    final zzbdz zzerw;
    final zzbfk zzewk;
    private final String zzewl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfh(zzbdz zzbdzVar, zzbfk zzbfkVar, String str) {
        this.zzerw = zzbdzVar;
        this.zzewk = zzbfkVar;
        this.zzewl = str;
        com.google.android.gms.ads.internal.zzbv.C().zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
        this.zzewk.abort();
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        try {
            this.zzewk.zzex(this.zzewl);
        } finally {
            zzayh.zzelc.post(new RunnableC1026of(this));
        }
    }
}
