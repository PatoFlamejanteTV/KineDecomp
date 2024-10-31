package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbo extends zzbut<zzbo> {
    private Long zzhh = null;
    private Integer zzhi = null;
    private Boolean zzhj = null;
    private int[] zzhk = zzbvc.zzfsg;
    private Long zzhl = null;

    public zzbo() {
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        Long l = this.zzhh;
        if (l != null) {
            zzburVar.zzr(1, l.longValue());
        }
        Integer num = this.zzhi;
        if (num != null) {
            zzburVar.zzv(2, num.intValue());
        }
        Boolean bool = this.zzhj;
        if (bool != null) {
            zzburVar.zzj(3, bool.booleanValue());
        }
        int[] iArr = this.zzhk;
        if (iArr != null && iArr.length > 0) {
            int i = 0;
            while (true) {
                int[] iArr2 = this.zzhk;
                if (i >= iArr2.length) {
                    break;
                }
                zzburVar.zzv(4, iArr2[i]);
                i++;
            }
        }
        Long l2 = this.zzhl;
        if (l2 != null) {
            zzburVar.zzj(5, l2.longValue());
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int[] iArr;
        int zzt = super.zzt();
        Long l = this.zzhh;
        if (l != null) {
            zzt += zzbur.zzm(1, l.longValue());
        }
        Integer num = this.zzhi;
        if (num != null) {
            zzt += zzbur.zzz(2, num.intValue());
        }
        Boolean bool = this.zzhj;
        if (bool != null) {
            bool.booleanValue();
            zzt += zzbur.zzfd(3) + 1;
        }
        int[] iArr2 = this.zzhk;
        if (iArr2 != null && iArr2.length > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                iArr = this.zzhk;
                if (i >= iArr.length) {
                    break;
                }
                i2 += zzbur.zzfe(iArr[i]);
                i++;
            }
            zzt = zzt + i2 + (iArr.length * 1);
        }
        Long l2 = this.zzhl;
        return l2 != null ? zzt + zzbur.zzn(5, l2.longValue()) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 8) {
                this.zzhh = Long.valueOf(zzbuqVar.zzaln());
            } else if (zzaku == 16) {
                this.zzhi = Integer.valueOf(zzbuqVar.zzalm());
            } else if (zzaku == 24) {
                this.zzhj = Boolean.valueOf(zzbuqVar.zzala());
            } else if (zzaku == 32) {
                int zzb = zzbvc.zzb(zzbuqVar, 32);
                int[] iArr = this.zzhk;
                int length = iArr == null ? 0 : iArr.length;
                int[] iArr2 = new int[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzhk, 0, iArr2, 0, length);
                }
                while (length < iArr2.length - 1) {
                    iArr2[length] = zzbuqVar.zzalm();
                    zzbuqVar.zzaku();
                    length++;
                }
                iArr2[length] = zzbuqVar.zzalm();
                this.zzhk = iArr2;
            } else if (zzaku == 34) {
                int zzer = zzbuqVar.zzer(zzbuqVar.zzalm());
                int position = zzbuqVar.getPosition();
                int i = 0;
                while (zzbuqVar.zzapl() > 0) {
                    zzbuqVar.zzalm();
                    i++;
                }
                zzbuqVar.zzgc(position);
                int[] iArr3 = this.zzhk;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int[] iArr4 = new int[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.zzhk, 0, iArr4, 0, length2);
                }
                while (length2 < iArr4.length) {
                    iArr4[length2] = zzbuqVar.zzalm();
                    length2++;
                }
                this.zzhk = iArr4;
                zzbuqVar.zzes(zzer);
            } else if (zzaku != 40) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                this.zzhl = Long.valueOf(zzbuqVar.zzaln());
            }
        }
    }
}
