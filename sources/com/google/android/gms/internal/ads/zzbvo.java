package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbvo extends zzbut<zzbvo> {
    public String zzegh = null;

    public zzbvo() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        String str = this.zzegh;
        if (str != null) {
            zzburVar.zzf(1, str);
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        String str = this.zzegh;
        return str != null ? zzt + zzbur.zzg(1, str) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku != 10) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                this.zzegh = zzbuqVar.readString();
            }
        }
    }
}
