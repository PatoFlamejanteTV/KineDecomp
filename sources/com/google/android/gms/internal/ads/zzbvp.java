package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbvp extends zzbut<zzbvp> {
    private static volatile zzbvp[] zzgbi;
    public byte[] zzgbj = null;
    public byte[] zzgbk = null;

    public zzbvp() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    public static zzbvp[] zzaqd() {
        if (zzgbi == null) {
            synchronized (zzbux.zzfws) {
                if (zzgbi == null) {
                    zzgbi = new zzbvp[0];
                }
            }
        }
        return zzgbi;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        zzburVar.zza(1, this.zzgbj);
        byte[] bArr = this.zzgbk;
        if (bArr != null) {
            zzburVar.zza(2, bArr);
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt() + zzbur.zzb(1, this.zzgbj);
        byte[] bArr = this.zzgbk;
        return bArr != null ? zzt + zzbur.zzb(2, bArr) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                this.zzgbj = zzbuqVar.readBytes();
            } else if (zzaku != 18) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                this.zzgbk = zzbuqVar.readBytes();
            }
        }
    }
}
