package com.google.android.gms.internal.gtm;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.gtm.zzc;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzi extends zzuq<zzi> {
    public String version;
    private String[] zzph;
    public String[] zzpi;
    public zzl[] zzpj;
    public zzc.zzd[] zzpk;
    public zzc.zzb[] zzpl;
    public zzc.zzb[] zzpm;
    public zzc.zzb[] zzpn;
    public zzc.zze[] zzpo;
    private String zzpp;
    private String zzpq;
    private String zzpr;
    private zzc.zza zzps;
    private float zzpt;
    private boolean zzpu;
    private String[] zzpv;
    public int zzpw;

    public zzi() {
        String[] strArr = zzuz.zzbhu;
        this.zzph = strArr;
        this.zzpi = strArr;
        this.zzpj = zzl.zzaa();
        this.zzpk = new zzc.zzd[0];
        this.zzpl = new zzc.zzb[0];
        this.zzpm = new zzc.zzb[0];
        this.zzpn = new zzc.zzb[0];
        this.zzpo = new zzc.zze[0];
        this.zzpp = "";
        this.zzpq = "";
        this.zzpr = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.version = "";
        this.zzps = null;
        this.zzpt = 0.0f;
        this.zzpu = false;
        this.zzpv = zzuz.zzbhu;
        this.zzpw = 0;
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzi)) {
            return false;
        }
        zzi zziVar = (zzi) obj;
        if (!zzuu.equals(this.zzph, zziVar.zzph) || !zzuu.equals(this.zzpi, zziVar.zzpi) || !zzuu.equals(this.zzpj, zziVar.zzpj) || !zzuu.equals(this.zzpk, zziVar.zzpk) || !zzuu.equals(this.zzpl, zziVar.zzpl) || !zzuu.equals(this.zzpm, zziVar.zzpm) || !zzuu.equals(this.zzpn, zziVar.zzpn) || !zzuu.equals(this.zzpo, zziVar.zzpo)) {
            return false;
        }
        String str = this.zzpp;
        if (str == null) {
            if (zziVar.zzpp != null) {
                return false;
            }
        } else if (!str.equals(zziVar.zzpp)) {
            return false;
        }
        String str2 = this.zzpq;
        if (str2 == null) {
            if (zziVar.zzpq != null) {
                return false;
            }
        } else if (!str2.equals(zziVar.zzpq)) {
            return false;
        }
        String str3 = this.zzpr;
        if (str3 == null) {
            if (zziVar.zzpr != null) {
                return false;
            }
        } else if (!str3.equals(zziVar.zzpr)) {
            return false;
        }
        String str4 = this.version;
        if (str4 == null) {
            if (zziVar.version != null) {
                return false;
            }
        } else if (!str4.equals(zziVar.version)) {
            return false;
        }
        zzc.zza zzaVar = this.zzps;
        if (zzaVar == null) {
            if (zziVar.zzps != null) {
                return false;
            }
        } else if (!zzaVar.equals(zziVar.zzps)) {
            return false;
        }
        if (Float.floatToIntBits(this.zzpt) != Float.floatToIntBits(zziVar.zzpt) || this.zzpu != zziVar.zzpu || !zzuu.equals(this.zzpv, zziVar.zzpv) || this.zzpw != zziVar.zzpw) {
            return false;
        }
        zzus zzusVar = this.zzbhb;
        if (zzusVar != null && !zzusVar.isEmpty()) {
            return this.zzbhb.equals(zziVar.zzbhb);
        }
        zzus zzusVar2 = zziVar.zzbhb;
        return zzusVar2 == null || zzusVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (((((((((((((((((zzi.class.getName().hashCode() + 527) * 31) + zzuu.hashCode(this.zzph)) * 31) + zzuu.hashCode(this.zzpi)) * 31) + zzuu.hashCode(this.zzpj)) * 31) + zzuu.hashCode(this.zzpk)) * 31) + zzuu.hashCode(this.zzpl)) * 31) + zzuu.hashCode(this.zzpm)) * 31) + zzuu.hashCode(this.zzpn)) * 31) + zzuu.hashCode(this.zzpo)) * 31;
        String str = this.zzpp;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzpq;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zzpr;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.version;
        int hashCode5 = hashCode4 + (str4 == null ? 0 : str4.hashCode());
        zzc.zza zzaVar = this.zzps;
        int hashCode6 = ((((((((((hashCode5 * 31) + (zzaVar == null ? 0 : zzaVar.hashCode())) * 31) + Float.floatToIntBits(this.zzpt)) * 31) + (this.zzpu ? 1231 : 1237)) * 31) + zzuu.hashCode(this.zzpv)) * 31) + this.zzpw) * 31;
        zzus zzusVar = this.zzbhb;
        if (zzusVar != null && !zzusVar.isEmpty()) {
            i = this.zzbhb.hashCode();
        }
        return hashCode6 + i;
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final void zza(zzuo zzuoVar) throws IOException {
        String[] strArr = this.zzpi;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.zzpi;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    zzuoVar.zza(1, str);
                }
                i2++;
            }
        }
        zzl[] zzlVarArr = this.zzpj;
        if (zzlVarArr != null && zzlVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzl[] zzlVarArr2 = this.zzpj;
                if (i3 >= zzlVarArr2.length) {
                    break;
                }
                zzl zzlVar = zzlVarArr2[i3];
                if (zzlVar != null) {
                    zzuoVar.zza(2, zzlVar);
                }
                i3++;
            }
        }
        zzc.zzd[] zzdVarArr = this.zzpk;
        if (zzdVarArr != null && zzdVarArr.length > 0) {
            int i4 = 0;
            while (true) {
                zzc.zzd[] zzdVarArr2 = this.zzpk;
                if (i4 >= zzdVarArr2.length) {
                    break;
                }
                zzc.zzd zzdVar = zzdVarArr2[i4];
                if (zzdVar != null) {
                    zzuoVar.zze(3, zzdVar);
                }
                i4++;
            }
        }
        zzc.zzb[] zzbVarArr = this.zzpl;
        if (zzbVarArr != null && zzbVarArr.length > 0) {
            int i5 = 0;
            while (true) {
                zzc.zzb[] zzbVarArr2 = this.zzpl;
                if (i5 >= zzbVarArr2.length) {
                    break;
                }
                zzc.zzb zzbVar = zzbVarArr2[i5];
                if (zzbVar != null) {
                    zzuoVar.zze(4, zzbVar);
                }
                i5++;
            }
        }
        zzc.zzb[] zzbVarArr3 = this.zzpm;
        if (zzbVarArr3 != null && zzbVarArr3.length > 0) {
            int i6 = 0;
            while (true) {
                zzc.zzb[] zzbVarArr4 = this.zzpm;
                if (i6 >= zzbVarArr4.length) {
                    break;
                }
                zzc.zzb zzbVar2 = zzbVarArr4[i6];
                if (zzbVar2 != null) {
                    zzuoVar.zze(5, zzbVar2);
                }
                i6++;
            }
        }
        zzc.zzb[] zzbVarArr5 = this.zzpn;
        if (zzbVarArr5 != null && zzbVarArr5.length > 0) {
            int i7 = 0;
            while (true) {
                zzc.zzb[] zzbVarArr6 = this.zzpn;
                if (i7 >= zzbVarArr6.length) {
                    break;
                }
                zzc.zzb zzbVar3 = zzbVarArr6[i7];
                if (zzbVar3 != null) {
                    zzuoVar.zze(6, zzbVar3);
                }
                i7++;
            }
        }
        zzc.zze[] zzeVarArr = this.zzpo;
        if (zzeVarArr != null && zzeVarArr.length > 0) {
            int i8 = 0;
            while (true) {
                zzc.zze[] zzeVarArr2 = this.zzpo;
                if (i8 >= zzeVarArr2.length) {
                    break;
                }
                zzc.zze zzeVar = zzeVarArr2[i8];
                if (zzeVar != null) {
                    zzuoVar.zze(7, zzeVar);
                }
                i8++;
            }
        }
        String str2 = this.zzpp;
        if (str2 != null && !str2.equals("")) {
            zzuoVar.zza(9, this.zzpp);
        }
        String str3 = this.zzpq;
        if (str3 != null && !str3.equals("")) {
            zzuoVar.zza(10, this.zzpq);
        }
        String str4 = this.zzpr;
        if (str4 != null && !str4.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            zzuoVar.zza(12, this.zzpr);
        }
        String str5 = this.version;
        if (str5 != null && !str5.equals("")) {
            zzuoVar.zza(13, this.version);
        }
        zzc.zza zzaVar = this.zzps;
        if (zzaVar != null) {
            zzuoVar.zze(14, zzaVar);
        }
        if (Float.floatToIntBits(this.zzpt) != Float.floatToIntBits(0.0f)) {
            float f2 = this.zzpt;
            zzuoVar.zzd(15, 5);
            zzuoVar.zzcc(Float.floatToIntBits(f2));
        }
        String[] strArr3 = this.zzpv;
        if (strArr3 != null && strArr3.length > 0) {
            int i9 = 0;
            while (true) {
                String[] strArr4 = this.zzpv;
                if (i9 >= strArr4.length) {
                    break;
                }
                String str6 = strArr4[i9];
                if (str6 != null) {
                    zzuoVar.zza(16, str6);
                }
                i9++;
            }
        }
        int i10 = this.zzpw;
        if (i10 != 0) {
            zzuoVar.zze(17, i10);
        }
        boolean z = this.zzpu;
        if (z) {
            zzuoVar.zzb(18, z);
        }
        String[] strArr5 = this.zzph;
        if (strArr5 != null && strArr5.length > 0) {
            while (true) {
                String[] strArr6 = this.zzph;
                if (i >= strArr6.length) {
                    break;
                }
                String str7 = strArr6[i];
                if (str7 != null) {
                    zzuoVar.zza(19, str7);
                }
                i++;
            }
        }
        super.zza(zzuoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final int zzy() {
        int zzy = super.zzy();
        String[] strArr = this.zzpi;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.zzpi;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i4++;
                    i3 += zzuo.zzda(str);
                }
                i2++;
            }
            zzy = zzy + i3 + (i4 * 1);
        }
        zzl[] zzlVarArr = this.zzpj;
        if (zzlVarArr != null && zzlVarArr.length > 0) {
            int i5 = zzy;
            int i6 = 0;
            while (true) {
                zzl[] zzlVarArr2 = this.zzpj;
                if (i6 >= zzlVarArr2.length) {
                    break;
                }
                zzl zzlVar = zzlVarArr2[i6];
                if (zzlVar != null) {
                    i5 += zzuo.zzb(2, zzlVar);
                }
                i6++;
            }
            zzy = i5;
        }
        zzc.zzd[] zzdVarArr = this.zzpk;
        if (zzdVarArr != null && zzdVarArr.length > 0) {
            int i7 = zzy;
            int i8 = 0;
            while (true) {
                zzc.zzd[] zzdVarArr2 = this.zzpk;
                if (i8 >= zzdVarArr2.length) {
                    break;
                }
                zzc.zzd zzdVar = zzdVarArr2[i8];
                if (zzdVar != null) {
                    i7 += zzqj.zzc(3, zzdVar);
                }
                i8++;
            }
            zzy = i7;
        }
        zzc.zzb[] zzbVarArr = this.zzpl;
        if (zzbVarArr != null && zzbVarArr.length > 0) {
            int i9 = zzy;
            int i10 = 0;
            while (true) {
                zzc.zzb[] zzbVarArr2 = this.zzpl;
                if (i10 >= zzbVarArr2.length) {
                    break;
                }
                zzc.zzb zzbVar = zzbVarArr2[i10];
                if (zzbVar != null) {
                    i9 += zzqj.zzc(4, zzbVar);
                }
                i10++;
            }
            zzy = i9;
        }
        zzc.zzb[] zzbVarArr3 = this.zzpm;
        if (zzbVarArr3 != null && zzbVarArr3.length > 0) {
            int i11 = zzy;
            int i12 = 0;
            while (true) {
                zzc.zzb[] zzbVarArr4 = this.zzpm;
                if (i12 >= zzbVarArr4.length) {
                    break;
                }
                zzc.zzb zzbVar2 = zzbVarArr4[i12];
                if (zzbVar2 != null) {
                    i11 += zzqj.zzc(5, zzbVar2);
                }
                i12++;
            }
            zzy = i11;
        }
        zzc.zzb[] zzbVarArr5 = this.zzpn;
        if (zzbVarArr5 != null && zzbVarArr5.length > 0) {
            int i13 = zzy;
            int i14 = 0;
            while (true) {
                zzc.zzb[] zzbVarArr6 = this.zzpn;
                if (i14 >= zzbVarArr6.length) {
                    break;
                }
                zzc.zzb zzbVar3 = zzbVarArr6[i14];
                if (zzbVar3 != null) {
                    i13 += zzqj.zzc(6, zzbVar3);
                }
                i14++;
            }
            zzy = i13;
        }
        zzc.zze[] zzeVarArr = this.zzpo;
        if (zzeVarArr != null && zzeVarArr.length > 0) {
            int i15 = zzy;
            int i16 = 0;
            while (true) {
                zzc.zze[] zzeVarArr2 = this.zzpo;
                if (i16 >= zzeVarArr2.length) {
                    break;
                }
                zzc.zze zzeVar = zzeVarArr2[i16];
                if (zzeVar != null) {
                    i15 += zzqj.zzc(7, zzeVar);
                }
                i16++;
            }
            zzy = i15;
        }
        String str2 = this.zzpp;
        if (str2 != null && !str2.equals("")) {
            zzy += zzuo.zzb(9, this.zzpp);
        }
        String str3 = this.zzpq;
        if (str3 != null && !str3.equals("")) {
            zzy += zzuo.zzb(10, this.zzpq);
        }
        String str4 = this.zzpr;
        if (str4 != null && !str4.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            zzy += zzuo.zzb(12, this.zzpr);
        }
        String str5 = this.version;
        if (str5 != null && !str5.equals("")) {
            zzy += zzuo.zzb(13, this.version);
        }
        zzc.zza zzaVar = this.zzps;
        if (zzaVar != null) {
            zzy += zzqj.zzc(14, zzaVar);
        }
        if (Float.floatToIntBits(this.zzpt) != Float.floatToIntBits(0.0f)) {
            zzy += zzuo.zzbb(15) + 4;
        }
        String[] strArr3 = this.zzpv;
        if (strArr3 != null && strArr3.length > 0) {
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                String[] strArr4 = this.zzpv;
                if (i17 >= strArr4.length) {
                    break;
                }
                String str6 = strArr4[i17];
                if (str6 != null) {
                    i19++;
                    i18 += zzuo.zzda(str6);
                }
                i17++;
            }
            zzy = zzy + i18 + (i19 * 2);
        }
        int i20 = this.zzpw;
        if (i20 != 0) {
            zzy += zzuo.zzi(17, i20);
        }
        if (this.zzpu) {
            zzy += zzuo.zzbb(18) + 1;
        }
        String[] strArr5 = this.zzph;
        if (strArr5 == null || strArr5.length <= 0) {
            return zzy;
        }
        int i21 = 0;
        int i22 = 0;
        while (true) {
            String[] strArr6 = this.zzph;
            if (i >= strArr6.length) {
                return zzy + i21 + (i22 * 2);
            }
            String str7 = strArr6[i];
            if (str7 != null) {
                i22++;
                i21 += zzuo.zzda(str7);
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public final /* synthetic */ zzuw zza(zzun zzunVar) throws IOException {
        while (true) {
            int zzni = zzunVar.zzni();
            switch (zzni) {
                case 0:
                    return this;
                case 10:
                    int zzb = zzuz.zzb(zzunVar, 10);
                    String[] strArr = this.zzpi;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzpi, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = zzunVar.readString();
                        zzunVar.zzni();
                        length++;
                    }
                    strArr2[length] = zzunVar.readString();
                    this.zzpi = strArr2;
                    break;
                case 18:
                    int zzb2 = zzuz.zzb(zzunVar, 18);
                    zzl[] zzlVarArr = this.zzpj;
                    int length2 = zzlVarArr == null ? 0 : zzlVarArr.length;
                    zzl[] zzlVarArr2 = new zzl[zzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzpj, 0, zzlVarArr2, 0, length2);
                    }
                    while (length2 < zzlVarArr2.length - 1) {
                        zzlVarArr2[length2] = new zzl();
                        zzunVar.zza(zzlVarArr2[length2]);
                        zzunVar.zzni();
                        length2++;
                    }
                    zzlVarArr2[length2] = new zzl();
                    zzunVar.zza(zzlVarArr2[length2]);
                    this.zzpj = zzlVarArr2;
                    break;
                case 26:
                    int zzb3 = zzuz.zzb(zzunVar, 26);
                    zzc.zzd[] zzdVarArr = this.zzpk;
                    int length3 = zzdVarArr == null ? 0 : zzdVarArr.length;
                    zzc.zzd[] zzdVarArr2 = new zzc.zzd[zzb3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzpk, 0, zzdVarArr2, 0, length3);
                    }
                    while (length3 < zzdVarArr2.length - 1) {
                        zzdVarArr2[length3] = (zzc.zzd) zzunVar.zza(zzc.zzd.zza());
                        zzunVar.zzni();
                        length3++;
                    }
                    zzdVarArr2[length3] = (zzc.zzd) zzunVar.zza(zzc.zzd.zza());
                    this.zzpk = zzdVarArr2;
                    break;
                case 34:
                    int zzb4 = zzuz.zzb(zzunVar, 34);
                    zzc.zzb[] zzbVarArr = this.zzpl;
                    int length4 = zzbVarArr == null ? 0 : zzbVarArr.length;
                    zzc.zzb[] zzbVarArr2 = new zzc.zzb[zzb4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.zzpl, 0, zzbVarArr2, 0, length4);
                    }
                    while (length4 < zzbVarArr2.length - 1) {
                        zzbVarArr2[length4] = (zzc.zzb) zzunVar.zza(zzc.zzb.zza());
                        zzunVar.zzni();
                        length4++;
                    }
                    zzbVarArr2[length4] = (zzc.zzb) zzunVar.zza(zzc.zzb.zza());
                    this.zzpl = zzbVarArr2;
                    break;
                case 42:
                    int zzb5 = zzuz.zzb(zzunVar, 42);
                    zzc.zzb[] zzbVarArr3 = this.zzpm;
                    int length5 = zzbVarArr3 == null ? 0 : zzbVarArr3.length;
                    zzc.zzb[] zzbVarArr4 = new zzc.zzb[zzb5 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.zzpm, 0, zzbVarArr4, 0, length5);
                    }
                    while (length5 < zzbVarArr4.length - 1) {
                        zzbVarArr4[length5] = (zzc.zzb) zzunVar.zza(zzc.zzb.zza());
                        zzunVar.zzni();
                        length5++;
                    }
                    zzbVarArr4[length5] = (zzc.zzb) zzunVar.zza(zzc.zzb.zza());
                    this.zzpm = zzbVarArr4;
                    break;
                case 50:
                    int zzb6 = zzuz.zzb(zzunVar, 50);
                    zzc.zzb[] zzbVarArr5 = this.zzpn;
                    int length6 = zzbVarArr5 == null ? 0 : zzbVarArr5.length;
                    zzc.zzb[] zzbVarArr6 = new zzc.zzb[zzb6 + length6];
                    if (length6 != 0) {
                        System.arraycopy(this.zzpn, 0, zzbVarArr6, 0, length6);
                    }
                    while (length6 < zzbVarArr6.length - 1) {
                        zzbVarArr6[length6] = (zzc.zzb) zzunVar.zza(zzc.zzb.zza());
                        zzunVar.zzni();
                        length6++;
                    }
                    zzbVarArr6[length6] = (zzc.zzb) zzunVar.zza(zzc.zzb.zza());
                    this.zzpn = zzbVarArr6;
                    break;
                case 58:
                    int zzb7 = zzuz.zzb(zzunVar, 58);
                    zzc.zze[] zzeVarArr = this.zzpo;
                    int length7 = zzeVarArr == null ? 0 : zzeVarArr.length;
                    zzc.zze[] zzeVarArr2 = new zzc.zze[zzb7 + length7];
                    if (length7 != 0) {
                        System.arraycopy(this.zzpo, 0, zzeVarArr2, 0, length7);
                    }
                    while (length7 < zzeVarArr2.length - 1) {
                        zzeVarArr2[length7] = (zzc.zze) zzunVar.zza(zzc.zze.zza());
                        zzunVar.zzni();
                        length7++;
                    }
                    zzeVarArr2[length7] = (zzc.zze) zzunVar.zza(zzc.zze.zza());
                    this.zzpo = zzeVarArr2;
                    break;
                case 74:
                    this.zzpp = zzunVar.readString();
                    break;
                case 82:
                    this.zzpq = zzunVar.readString();
                    break;
                case 98:
                    this.zzpr = zzunVar.readString();
                    break;
                case 106:
                    this.version = zzunVar.readString();
                    break;
                case 114:
                    zzc.zza zzaVar = (zzc.zza) zzunVar.zza(zzc.zza.zza());
                    zzc.zza zzaVar2 = this.zzps;
                    if (zzaVar2 != null) {
                        zzaVar = (zzc.zza) zzaVar2.zzpd().zza((zzc.zza.C0085zza) zzaVar).zzpm();
                    }
                    this.zzps = zzaVar;
                    break;
                case 125:
                    this.zzpt = Float.intBitsToFloat(zzunVar.zzoc());
                    break;
                case 130:
                    int zzb8 = zzuz.zzb(zzunVar, 130);
                    String[] strArr3 = this.zzpv;
                    int length8 = strArr3 == null ? 0 : strArr3.length;
                    String[] strArr4 = new String[zzb8 + length8];
                    if (length8 != 0) {
                        System.arraycopy(this.zzpv, 0, strArr4, 0, length8);
                    }
                    while (length8 < strArr4.length - 1) {
                        strArr4[length8] = zzunVar.readString();
                        zzunVar.zzni();
                        length8++;
                    }
                    strArr4[length8] = zzunVar.readString();
                    this.zzpv = strArr4;
                    break;
                case 136:
                    this.zzpw = zzunVar.zzoa();
                    break;
                case 144:
                    this.zzpu = zzunVar.zzno();
                    break;
                case 154:
                    int zzb9 = zzuz.zzb(zzunVar, 154);
                    String[] strArr5 = this.zzph;
                    int length9 = strArr5 == null ? 0 : strArr5.length;
                    String[] strArr6 = new String[zzb9 + length9];
                    if (length9 != 0) {
                        System.arraycopy(this.zzph, 0, strArr6, 0, length9);
                    }
                    while (length9 < strArr6.length - 1) {
                        strArr6[length9] = zzunVar.readString();
                        zzunVar.zzni();
                        length9++;
                    }
                    strArr6[length9] = zzunVar.readString();
                    this.zzph = strArr6;
                    break;
                default:
                    if (!super.zza(zzunVar, zzni)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
