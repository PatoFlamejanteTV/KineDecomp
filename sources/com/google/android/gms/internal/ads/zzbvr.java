package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbvd;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbvr extends zzbut<zzbvr> {
    private zzbvd.zzb.zze.C0071zzb zzgbq = null;
    private zzbvp[] zzgbm = zzbvp.zzaqd();
    private byte[] zzgbn = null;
    private byte[] zzgbo = null;
    private Integer zzgbp = null;
    private byte[] zzgbr = null;

    public zzbvr() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        zzbvd.zzb.zze.C0071zzb c0071zzb = this.zzgbq;
        if (c0071zzb != null) {
            zzburVar.zze(1, c0071zzb);
        }
        zzbvp[] zzbvpVarArr = this.zzgbm;
        if (zzbvpVarArr != null && zzbvpVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzbvp[] zzbvpVarArr2 = this.zzgbm;
                if (i >= zzbvpVarArr2.length) {
                    break;
                }
                zzbvp zzbvpVar = zzbvpVarArr2[i];
                if (zzbvpVar != null) {
                    zzburVar.zza(2, zzbvpVar);
                }
                i++;
            }
        }
        byte[] bArr = this.zzgbn;
        if (bArr != null) {
            zzburVar.zza(3, bArr);
        }
        byte[] bArr2 = this.zzgbo;
        if (bArr2 != null) {
            zzburVar.zza(4, bArr2);
        }
        Integer num = this.zzgbp;
        if (num != null) {
            zzburVar.zzv(5, num.intValue());
        }
        byte[] bArr3 = this.zzgbr;
        if (bArr3 != null) {
            zzburVar.zza(6, bArr3);
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        zzbvd.zzb.zze.C0071zzb c0071zzb = this.zzgbq;
        if (c0071zzb != null) {
            zzt += zzbqk.zzc(1, c0071zzb);
        }
        zzbvp[] zzbvpVarArr = this.zzgbm;
        if (zzbvpVarArr != null && zzbvpVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzbvp[] zzbvpVarArr2 = this.zzgbm;
                if (i >= zzbvpVarArr2.length) {
                    break;
                }
                zzbvp zzbvpVar = zzbvpVarArr2[i];
                if (zzbvpVar != null) {
                    zzt += zzbur.zzb(2, zzbvpVar);
                }
                i++;
            }
        }
        byte[] bArr = this.zzgbn;
        if (bArr != null) {
            zzt += zzbur.zzb(3, bArr);
        }
        byte[] bArr2 = this.zzgbo;
        if (bArr2 != null) {
            zzt += zzbur.zzb(4, bArr2);
        }
        Integer num = this.zzgbp;
        if (num != null) {
            zzt += zzbur.zzz(5, num.intValue());
        }
        byte[] bArr3 = this.zzgbr;
        return bArr3 != null ? zzt + zzbur.zzb(6, bArr3) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                this.zzgbq = (zzbvd.zzb.zze.C0071zzb) zzbuqVar.zza(zzbvd.zzb.zze.C0071zzb.zzon());
            } else if (zzaku == 18) {
                int zzb = zzbvc.zzb(zzbuqVar, 18);
                zzbvp[] zzbvpVarArr = this.zzgbm;
                int length = zzbvpVarArr == null ? 0 : zzbvpVarArr.length;
                zzbvp[] zzbvpVarArr2 = new zzbvp[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzgbm, 0, zzbvpVarArr2, 0, length);
                }
                while (length < zzbvpVarArr2.length - 1) {
                    zzbvpVarArr2[length] = new zzbvp();
                    zzbuqVar.zza(zzbvpVarArr2[length]);
                    zzbuqVar.zzaku();
                    length++;
                }
                zzbvpVarArr2[length] = new zzbvp();
                zzbuqVar.zza(zzbvpVarArr2[length]);
                this.zzgbm = zzbvpVarArr2;
            } else if (zzaku == 26) {
                this.zzgbn = zzbuqVar.readBytes();
            } else if (zzaku == 34) {
                this.zzgbo = zzbuqVar.readBytes();
            } else if (zzaku == 40) {
                this.zzgbp = Integer.valueOf(zzbuqVar.zzakx());
            } else if (zzaku != 50) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                this.zzgbr = zzbuqVar.readBytes();
            }
        }
    }
}
