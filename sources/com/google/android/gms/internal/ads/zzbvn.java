package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbvd;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbvn extends zzbut<zzbvn> {
    private String[] zzgba;
    private String zzgbb;
    private Boolean zzgbc;
    private Boolean zzgbd;
    private byte[] zzgbe;
    public zzbvu zzgbf;
    public String[] zzgbg;
    public String[] zzgbh;
    public Integer zzgar = null;
    private zzbvd.zza.zzc zzgas = null;
    public String url = null;
    public String zzgat = null;
    private String zzgau = null;
    public zzbvo zzgav = null;
    public zzbvt[] zzgaw = zzbvt.zzaqe();
    public String zzgax = null;
    public zzbvs zzgay = null;
    private Boolean zzgaz = null;

    public zzbvn() {
        String[] strArr = zzbvc.zzfxc;
        this.zzgba = strArr;
        this.zzgbb = null;
        this.zzgbc = null;
        this.zzgbd = null;
        this.zzgbe = null;
        this.zzgbf = null;
        this.zzgbg = strArr;
        this.zzgbh = strArr;
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    private final zzbvn zzf(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            switch (zzaku) {
                case 0:
                    return this;
                case 10:
                    this.url = zzbuqVar.readString();
                    break;
                case 18:
                    this.zzgat = zzbuqVar.readString();
                    break;
                case 26:
                    this.zzgau = zzbuqVar.readString();
                    break;
                case 34:
                    int zzb = zzbvc.zzb(zzbuqVar, 34);
                    zzbvt[] zzbvtVarArr = this.zzgaw;
                    int length = zzbvtVarArr == null ? 0 : zzbvtVarArr.length;
                    zzbvt[] zzbvtVarArr2 = new zzbvt[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzgaw, 0, zzbvtVarArr2, 0, length);
                    }
                    while (length < zzbvtVarArr2.length - 1) {
                        zzbvtVarArr2[length] = new zzbvt();
                        zzbuqVar.zza(zzbvtVarArr2[length]);
                        zzbuqVar.zzaku();
                        length++;
                    }
                    zzbvtVarArr2[length] = new zzbvt();
                    zzbuqVar.zza(zzbvtVarArr2[length]);
                    this.zzgaw = zzbvtVarArr2;
                    break;
                case 40:
                    this.zzgaz = Boolean.valueOf(zzbuqVar.zzala());
                    break;
                case 50:
                    int zzb2 = zzbvc.zzb(zzbuqVar, 50);
                    String[] strArr = this.zzgba;
                    int length2 = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[zzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzgba, 0, strArr2, 0, length2);
                    }
                    while (length2 < strArr2.length - 1) {
                        strArr2[length2] = zzbuqVar.readString();
                        zzbuqVar.zzaku();
                        length2++;
                    }
                    strArr2[length2] = zzbuqVar.readString();
                    this.zzgba = strArr2;
                    break;
                case 58:
                    this.zzgbb = zzbuqVar.readString();
                    break;
                case 64:
                    this.zzgbc = Boolean.valueOf(zzbuqVar.zzala());
                    break;
                case 72:
                    this.zzgbd = Boolean.valueOf(zzbuqVar.zzala());
                    break;
                case 80:
                    int position = zzbuqVar.getPosition();
                    try {
                        int zzakx = zzbuqVar.zzakx();
                        if (zzakx >= 0 && zzakx <= 9) {
                            this.zzgar = Integer.valueOf(zzakx);
                            break;
                        } else {
                            StringBuilder sb = new StringBuilder(42);
                            sb.append(zzakx);
                            sb.append(" is not a valid enum ReportType");
                            throw new IllegalArgumentException(sb.toString());
                            break;
                        }
                    } catch (IllegalArgumentException unused) {
                        zzbuqVar.zzgc(position);
                        zza(zzbuqVar, zzaku);
                        break;
                    }
                case 88:
                    int position2 = zzbuqVar.getPosition();
                    int zzakx2 = zzbuqVar.zzakx();
                    if (zzakx2 != 0 && zzakx2 != 1 && zzakx2 != 2 && zzakx2 != 3 && zzakx2 != 4) {
                        zzbuqVar.zzgc(position2);
                        zza(zzbuqVar, zzaku);
                        break;
                    } else {
                        this.zzgas = zzbvd.zza.zzc.zzgi(zzakx2);
                        break;
                    }
                case 98:
                    if (this.zzgav == null) {
                        this.zzgav = new zzbvo();
                    }
                    zzbuqVar.zza(this.zzgav);
                    break;
                case 106:
                    this.zzgax = zzbuqVar.readString();
                    break;
                case 114:
                    if (this.zzgay == null) {
                        this.zzgay = new zzbvs();
                    }
                    zzbuqVar.zza(this.zzgay);
                    break;
                case 122:
                    this.zzgbe = zzbuqVar.readBytes();
                    break;
                case 138:
                    if (this.zzgbf == null) {
                        this.zzgbf = new zzbvu();
                    }
                    zzbuqVar.zza(this.zzgbf);
                    break;
                case 162:
                    int zzb3 = zzbvc.zzb(zzbuqVar, 162);
                    String[] strArr3 = this.zzgbg;
                    int length3 = strArr3 == null ? 0 : strArr3.length;
                    String[] strArr4 = new String[zzb3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzgbg, 0, strArr4, 0, length3);
                    }
                    while (length3 < strArr4.length - 1) {
                        strArr4[length3] = zzbuqVar.readString();
                        zzbuqVar.zzaku();
                        length3++;
                    }
                    strArr4[length3] = zzbuqVar.readString();
                    this.zzgbg = strArr4;
                    break;
                case 170:
                    int zzb4 = zzbvc.zzb(zzbuqVar, 170);
                    String[] strArr5 = this.zzgbh;
                    int length4 = strArr5 == null ? 0 : strArr5.length;
                    String[] strArr6 = new String[zzb4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.zzgbh, 0, strArr6, 0, length4);
                    }
                    while (length4 < strArr6.length - 1) {
                        strArr6[length4] = zzbuqVar.readString();
                        zzbuqVar.zzaku();
                        length4++;
                    }
                    strArr6[length4] = zzbuqVar.readString();
                    this.zzgbh = strArr6;
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
        String str = this.url;
        if (str != null) {
            zzburVar.zzf(1, str);
        }
        String str2 = this.zzgat;
        if (str2 != null) {
            zzburVar.zzf(2, str2);
        }
        String str3 = this.zzgau;
        if (str3 != null) {
            zzburVar.zzf(3, str3);
        }
        zzbvt[] zzbvtVarArr = this.zzgaw;
        int i = 0;
        if (zzbvtVarArr != null && zzbvtVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzbvt[] zzbvtVarArr2 = this.zzgaw;
                if (i2 >= zzbvtVarArr2.length) {
                    break;
                }
                zzbvt zzbvtVar = zzbvtVarArr2[i2];
                if (zzbvtVar != null) {
                    zzburVar.zza(4, zzbvtVar);
                }
                i2++;
            }
        }
        Boolean bool = this.zzgaz;
        if (bool != null) {
            zzburVar.zzj(5, bool.booleanValue());
        }
        String[] strArr = this.zzgba;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.zzgba;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str4 = strArr2[i3];
                if (str4 != null) {
                    zzburVar.zzf(6, str4);
                }
                i3++;
            }
        }
        String str5 = this.zzgbb;
        if (str5 != null) {
            zzburVar.zzf(7, str5);
        }
        Boolean bool2 = this.zzgbc;
        if (bool2 != null) {
            zzburVar.zzj(8, bool2.booleanValue());
        }
        Boolean bool3 = this.zzgbd;
        if (bool3 != null) {
            zzburVar.zzj(9, bool3.booleanValue());
        }
        Integer num = this.zzgar;
        if (num != null) {
            zzburVar.zzv(10, num.intValue());
        }
        zzbvd.zza.zzc zzcVar = this.zzgas;
        if (zzcVar != null && zzcVar != null) {
            zzburVar.zzv(11, zzcVar.zzom());
        }
        zzbvo zzbvoVar = this.zzgav;
        if (zzbvoVar != null) {
            zzburVar.zza(12, zzbvoVar);
        }
        String str6 = this.zzgax;
        if (str6 != null) {
            zzburVar.zzf(13, str6);
        }
        zzbvs zzbvsVar = this.zzgay;
        if (zzbvsVar != null) {
            zzburVar.zza(14, zzbvsVar);
        }
        byte[] bArr = this.zzgbe;
        if (bArr != null) {
            zzburVar.zza(15, bArr);
        }
        zzbvu zzbvuVar = this.zzgbf;
        if (zzbvuVar != null) {
            zzburVar.zza(17, zzbvuVar);
        }
        String[] strArr3 = this.zzgbg;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr4 = this.zzgbg;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str7 = strArr4[i4];
                if (str7 != null) {
                    zzburVar.zzf(20, str7);
                }
                i4++;
            }
        }
        String[] strArr5 = this.zzgbh;
        if (strArr5 != null && strArr5.length > 0) {
            while (true) {
                String[] strArr6 = this.zzgbh;
                if (i >= strArr6.length) {
                    break;
                }
                String str8 = strArr6[i];
                if (str8 != null) {
                    zzburVar.zzf(21, str8);
                }
                i++;
            }
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        String str = this.url;
        if (str != null) {
            zzt += zzbur.zzg(1, str);
        }
        String str2 = this.zzgat;
        if (str2 != null) {
            zzt += zzbur.zzg(2, str2);
        }
        String str3 = this.zzgau;
        if (str3 != null) {
            zzt += zzbur.zzg(3, str3);
        }
        zzbvt[] zzbvtVarArr = this.zzgaw;
        int i = 0;
        if (zzbvtVarArr != null && zzbvtVarArr.length > 0) {
            int i2 = zzt;
            int i3 = 0;
            while (true) {
                zzbvt[] zzbvtVarArr2 = this.zzgaw;
                if (i3 >= zzbvtVarArr2.length) {
                    break;
                }
                zzbvt zzbvtVar = zzbvtVarArr2[i3];
                if (zzbvtVar != null) {
                    i2 += zzbur.zzb(4, zzbvtVar);
                }
                i3++;
            }
            zzt = i2;
        }
        Boolean bool = this.zzgaz;
        if (bool != null) {
            bool.booleanValue();
            zzt += zzbur.zzfd(5) + 1;
        }
        String[] strArr = this.zzgba;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                String[] strArr2 = this.zzgba;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str4 = strArr2[i4];
                if (str4 != null) {
                    i6++;
                    i5 += zzbur.zzfy(str4);
                }
                i4++;
            }
            zzt = zzt + i5 + (i6 * 1);
        }
        String str5 = this.zzgbb;
        if (str5 != null) {
            zzt += zzbur.zzg(7, str5);
        }
        Boolean bool2 = this.zzgbc;
        if (bool2 != null) {
            bool2.booleanValue();
            zzt += zzbur.zzfd(8) + 1;
        }
        Boolean bool3 = this.zzgbd;
        if (bool3 != null) {
            bool3.booleanValue();
            zzt += zzbur.zzfd(9) + 1;
        }
        Integer num = this.zzgar;
        if (num != null) {
            zzt += zzbur.zzz(10, num.intValue());
        }
        zzbvd.zza.zzc zzcVar = this.zzgas;
        if (zzcVar != null && zzcVar != null) {
            zzt += zzbur.zzz(11, zzcVar.zzom());
        }
        zzbvo zzbvoVar = this.zzgav;
        if (zzbvoVar != null) {
            zzt += zzbur.zzb(12, zzbvoVar);
        }
        String str6 = this.zzgax;
        if (str6 != null) {
            zzt += zzbur.zzg(13, str6);
        }
        zzbvs zzbvsVar = this.zzgay;
        if (zzbvsVar != null) {
            zzt += zzbur.zzb(14, zzbvsVar);
        }
        byte[] bArr = this.zzgbe;
        if (bArr != null) {
            zzt += zzbur.zzb(15, bArr);
        }
        zzbvu zzbvuVar = this.zzgbf;
        if (zzbvuVar != null) {
            zzt += zzbur.zzb(17, zzbvuVar);
        }
        String[] strArr3 = this.zzgbg;
        if (strArr3 != null && strArr3.length > 0) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                String[] strArr4 = this.zzgbg;
                if (i7 >= strArr4.length) {
                    break;
                }
                String str7 = strArr4[i7];
                if (str7 != null) {
                    i9++;
                    i8 += zzbur.zzfy(str7);
                }
                i7++;
            }
            zzt = zzt + i8 + (i9 * 2);
        }
        String[] strArr5 = this.zzgbh;
        if (strArr5 == null || strArr5.length <= 0) {
            return zzt;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr6 = this.zzgbh;
            if (i >= strArr6.length) {
                return zzt + i10 + (i11 * 2);
            }
            String str8 = strArr6[i];
            if (str8 != null) {
                i11++;
                i10 += zzbur.zzfy(str8);
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        zzf(zzbuqVar);
        return this;
    }
}
