package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbvt extends zzbut<zzbvt> {
    private static volatile zzbvt[] zzgbt;
    public Integer zzgbu = null;
    public String url = null;
    public zzbvq zzgbv = null;
    private zzbvr zzgbw = null;
    private Integer zzgbx = null;
    private int[] zzgby = zzbvc.zzfsg;
    private String zzgbz = null;
    public Integer zzgca = null;
    public String[] zzgcb = zzbvc.zzfxc;

    public zzbvt() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    public static zzbvt[] zzaqe() {
        if (zzgbt == null) {
            synchronized (zzbux.zzfws) {
                if (zzgbt == null) {
                    zzgbt = new zzbvt[0];
                }
            }
        }
        return zzgbt;
    }

    private final zzbvt zzh(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            switch (zzaku) {
                case 0:
                    return this;
                case 8:
                    this.zzgbu = Integer.valueOf(zzbuqVar.zzakx());
                    break;
                case 18:
                    this.url = zzbuqVar.readString();
                    break;
                case 26:
                    if (this.zzgbv == null) {
                        this.zzgbv = new zzbvq();
                    }
                    zzbuqVar.zza(this.zzgbv);
                    break;
                case 34:
                    if (this.zzgbw == null) {
                        this.zzgbw = new zzbvr();
                    }
                    zzbuqVar.zza(this.zzgbw);
                    break;
                case 40:
                    this.zzgbx = Integer.valueOf(zzbuqVar.zzakx());
                    break;
                case 48:
                    int zzb = zzbvc.zzb(zzbuqVar, 48);
                    int[] iArr = this.zzgby;
                    int length = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzgby, 0, iArr2, 0, length);
                    }
                    while (length < iArr2.length - 1) {
                        iArr2[length] = zzbuqVar.zzakx();
                        zzbuqVar.zzaku();
                        length++;
                    }
                    iArr2[length] = zzbuqVar.zzakx();
                    this.zzgby = iArr2;
                    break;
                case 50:
                    int zzer = zzbuqVar.zzer(zzbuqVar.zzalm());
                    int position = zzbuqVar.getPosition();
                    int i = 0;
                    while (zzbuqVar.zzapl() > 0) {
                        zzbuqVar.zzakx();
                        i++;
                    }
                    zzbuqVar.zzgc(position);
                    int[] iArr3 = this.zzgby;
                    int length2 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzgby, 0, iArr4, 0, length2);
                    }
                    while (length2 < iArr4.length) {
                        iArr4[length2] = zzbuqVar.zzakx();
                        length2++;
                    }
                    this.zzgby = iArr4;
                    zzbuqVar.zzes(zzer);
                    break;
                case 58:
                    this.zzgbz = zzbuqVar.readString();
                    break;
                case 64:
                    int position2 = zzbuqVar.getPosition();
                    try {
                        int zzakx = zzbuqVar.zzakx();
                        if (zzakx >= 0 && zzakx <= 3) {
                            this.zzgca = Integer.valueOf(zzakx);
                            break;
                        } else {
                            StringBuilder sb = new StringBuilder(46);
                            sb.append(zzakx);
                            sb.append(" is not a valid enum AdResourceType");
                            throw new IllegalArgumentException(sb.toString());
                            break;
                        }
                    } catch (IllegalArgumentException unused) {
                        zzbuqVar.zzgc(position2);
                        zza(zzbuqVar, zzaku);
                        break;
                    }
                case 74:
                    int zzb2 = zzbvc.zzb(zzbuqVar, 74);
                    String[] strArr = this.zzgcb;
                    int length3 = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[zzb2 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzgcb, 0, strArr2, 0, length3);
                    }
                    while (length3 < strArr2.length - 1) {
                        strArr2[length3] = zzbuqVar.readString();
                        zzbuqVar.zzaku();
                        length3++;
                    }
                    strArr2[length3] = zzbuqVar.readString();
                    this.zzgcb = strArr2;
                    break;
                default:
                    if (!super.zza(zzbuqVar, zzaku)) {
                        return this;
                    }
                    break;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        zzburVar.zzv(1, this.zzgbu.intValue());
        String str = this.url;
        if (str != null) {
            zzburVar.zzf(2, str);
        }
        zzbvq zzbvqVar = this.zzgbv;
        if (zzbvqVar != null) {
            zzburVar.zza(3, zzbvqVar);
        }
        zzbvr zzbvrVar = this.zzgbw;
        if (zzbvrVar != null) {
            zzburVar.zza(4, zzbvrVar);
        }
        Integer num = this.zzgbx;
        if (num != null) {
            zzburVar.zzv(5, num.intValue());
        }
        int[] iArr = this.zzgby;
        int i = 0;
        if (iArr != null && iArr.length > 0) {
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.zzgby;
                if (i2 >= iArr2.length) {
                    break;
                }
                zzburVar.zzv(6, iArr2[i2]);
                i2++;
            }
        }
        String str2 = this.zzgbz;
        if (str2 != null) {
            zzburVar.zzf(7, str2);
        }
        Integer num2 = this.zzgca;
        if (num2 != null) {
            zzburVar.zzv(8, num2.intValue());
        }
        String[] strArr = this.zzgcb;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.zzgcb;
                if (i >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i];
                if (str3 != null) {
                    zzburVar.zzf(9, str3);
                }
                i++;
            }
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int[] iArr;
        int zzt = super.zzt() + zzbur.zzz(1, this.zzgbu.intValue());
        String str = this.url;
        if (str != null) {
            zzt += zzbur.zzg(2, str);
        }
        zzbvq zzbvqVar = this.zzgbv;
        if (zzbvqVar != null) {
            zzt += zzbur.zzb(3, zzbvqVar);
        }
        zzbvr zzbvrVar = this.zzgbw;
        if (zzbvrVar != null) {
            zzt += zzbur.zzb(4, zzbvrVar);
        }
        Integer num = this.zzgbx;
        if (num != null) {
            zzt += zzbur.zzz(5, num.intValue());
        }
        int[] iArr2 = this.zzgby;
        int i = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                iArr = this.zzgby;
                if (i2 >= iArr.length) {
                    break;
                }
                i3 += zzbur.zzfe(iArr[i2]);
                i2++;
            }
            zzt = zzt + i3 + (iArr.length * 1);
        }
        String str2 = this.zzgbz;
        if (str2 != null) {
            zzt += zzbur.zzg(7, str2);
        }
        Integer num2 = this.zzgca;
        if (num2 != null) {
            zzt += zzbur.zzz(8, num2.intValue());
        }
        String[] strArr = this.zzgcb;
        if (strArr == null || strArr.length <= 0) {
            return zzt;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String[] strArr2 = this.zzgcb;
            if (i >= strArr2.length) {
                return zzt + i4 + (i5 * 1);
            }
            String str3 = strArr2[i];
            if (str3 != null) {
                i5++;
                i4 += zzbur.zzfy(str3);
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        zzh(zzbuqVar);
        return this;
    }
}
