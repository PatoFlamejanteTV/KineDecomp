package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbs extends zzbut<zzbs> {
    public Integer zzfy;
    private Integer zzfz;
    public byte[][] zzhr = zzbvc.zzfxd;
    public byte[] zzhm = null;

    public zzbs() {
        this.zzfwt = -1;
    }

    private final zzbs zzd(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                int zzb = zzbvc.zzb(zzbuqVar, 10);
                byte[][] bArr = this.zzhr;
                int length = bArr == null ? 0 : bArr.length;
                byte[][] bArr2 = new byte[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzhr, 0, bArr2, 0, length);
                }
                while (length < bArr2.length - 1) {
                    bArr2[length] = zzbuqVar.readBytes();
                    zzbuqVar.zzaku();
                    length++;
                }
                bArr2[length] = zzbuqVar.readBytes();
                this.zzhr = bArr2;
            } else if (zzaku == 18) {
                this.zzhm = zzbuqVar.readBytes();
            } else if (zzaku == 24) {
                int position = zzbuqVar.getPosition();
                try {
                    int zzalm = zzbuqVar.zzalm();
                    zzbk.zze(zzalm);
                    this.zzfz = Integer.valueOf(zzalm);
                } catch (IllegalArgumentException unused) {
                    zzbuqVar.zzgc(position);
                    zza(zzbuqVar, zzaku);
                }
            } else if (zzaku != 32) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                int position2 = zzbuqVar.getPosition();
                try {
                    int zzalm2 = zzbuqVar.zzalm();
                    zzbk.zzf(zzalm2);
                    this.zzfy = Integer.valueOf(zzalm2);
                } catch (IllegalArgumentException unused2) {
                    zzbuqVar.zzgc(position2);
                    zza(zzbuqVar, zzaku);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        byte[][] bArr = this.zzhr;
        if (bArr != null && bArr.length > 0) {
            int i = 0;
            while (true) {
                byte[][] bArr2 = this.zzhr;
                if (i >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i];
                if (bArr3 != null) {
                    zzburVar.zza(1, bArr3);
                }
                i++;
            }
        }
        byte[] bArr4 = this.zzhm;
        if (bArr4 != null) {
            zzburVar.zza(2, bArr4);
        }
        Integer num = this.zzfz;
        if (num != null) {
            zzburVar.zzv(3, num.intValue());
        }
        Integer num2 = this.zzfy;
        if (num2 != null) {
            zzburVar.zzv(4, num2.intValue());
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        byte[][] bArr = this.zzhr;
        if (bArr != null && bArr.length > 0) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte[][] bArr2 = this.zzhr;
                if (i >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i];
                if (bArr3 != null) {
                    i3++;
                    i2 += zzbur.zzy(bArr3);
                }
                i++;
            }
            zzt = zzt + i2 + (i3 * 1);
        }
        byte[] bArr4 = this.zzhm;
        if (bArr4 != null) {
            zzt += zzbur.zzb(2, bArr4);
        }
        Integer num = this.zzfz;
        if (num != null) {
            zzt += zzbur.zzz(3, num.intValue());
        }
        Integer num2 = this.zzfy;
        return num2 != null ? zzt + zzbur.zzz(4, num2.intValue()) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        zzd(zzbuqVar);
        return this;
    }
}
