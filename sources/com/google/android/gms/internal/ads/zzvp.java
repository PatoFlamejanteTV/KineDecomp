package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuw;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzvp extends zzbut<zzvp> {
    private Integer zzcho = null;
    public String zzchp = null;
    private Integer zzchq = null;
    private zzvc zzchr = null;
    private zzvq zzchs = null;
    public long[] zzcht = zzbvc.zzfwy;
    public zzvn zzchu = null;
    private zzvo zzchv = null;
    private zzuw.zzh zzchw = null;
    public zzvl zzchx = null;

    public zzvp() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        Integer num = this.zzcho;
        if (num != null) {
            zzburVar.zzv(9, num.intValue());
        }
        String str = this.zzchp;
        if (str != null) {
            zzburVar.zzf(10, str);
        }
        Integer num2 = this.zzchq;
        int i = 0;
        if (num2 != null) {
            int intValue = num2.intValue();
            zzburVar.zzu(11, 0);
            zzburVar.zzge(intValue);
        }
        zzvc zzvcVar = this.zzchr;
        if (zzvcVar != null && zzvcVar != null) {
            zzburVar.zzv(12, zzvcVar.zzom());
        }
        zzvq zzvqVar = this.zzchs;
        if (zzvqVar != null) {
            zzburVar.zza(13, zzvqVar);
        }
        long[] jArr = this.zzcht;
        if (jArr != null && jArr.length > 0) {
            while (true) {
                long[] jArr2 = this.zzcht;
                if (i >= jArr2.length) {
                    break;
                }
                zzburVar.zzj(14, jArr2[i]);
                i++;
            }
        }
        zzvn zzvnVar = this.zzchu;
        if (zzvnVar != null) {
            zzburVar.zza(15, zzvnVar);
        }
        zzvo zzvoVar = this.zzchv;
        if (zzvoVar != null) {
            zzburVar.zza(16, zzvoVar);
        }
        zzuw.zzh zzhVar = this.zzchw;
        if (zzhVar != null) {
            zzburVar.zze(17, zzhVar);
        }
        zzvl zzvlVar = this.zzchx;
        if (zzvlVar != null) {
            zzburVar.zza(18, zzvlVar);
        }
        super.zza(zzburVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        long[] jArr;
        int zzt = super.zzt();
        Integer num = this.zzcho;
        if (num != null) {
            zzt += zzbur.zzz(9, num.intValue());
        }
        String str = this.zzchp;
        if (str != null) {
            zzt += zzbur.zzg(10, str);
        }
        Integer num2 = this.zzchq;
        if (num2 != null) {
            zzt += zzbur.zzfd(11) + zzbur.zzfl(num2.intValue());
        }
        zzvc zzvcVar = this.zzchr;
        if (zzvcVar != null && zzvcVar != null) {
            zzt += zzbur.zzz(12, zzvcVar.zzom());
        }
        zzvq zzvqVar = this.zzchs;
        if (zzvqVar != null) {
            zzt += zzbur.zzb(13, zzvqVar);
        }
        long[] jArr2 = this.zzcht;
        if (jArr2 != null && jArr2.length > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                jArr = this.zzcht;
                if (i >= jArr.length) {
                    break;
                }
                i2 += zzbur.zzbl(jArr[i]);
                i++;
            }
            zzt = zzt + i2 + (jArr.length * 1);
        }
        zzvn zzvnVar = this.zzchu;
        if (zzvnVar != null) {
            zzt += zzbur.zzb(15, zzvnVar);
        }
        zzvo zzvoVar = this.zzchv;
        if (zzvoVar != null) {
            zzt += zzbur.zzb(16, zzvoVar);
        }
        zzuw.zzh zzhVar = this.zzchw;
        if (zzhVar != null) {
            zzt += zzbqk.zzc(17, zzhVar);
        }
        zzvl zzvlVar = this.zzchx;
        return zzvlVar != null ? zzt + zzbur.zzb(18, zzvlVar) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            switch (zzaku) {
                case 0:
                    return this;
                case 72:
                    this.zzcho = Integer.valueOf(zzbuqVar.zzalm());
                    break;
                case 82:
                    this.zzchp = zzbuqVar.readString();
                    break;
                case 88:
                    this.zzchq = Integer.valueOf(zzbuqVar.zzalm());
                    break;
                case 96:
                    int position = zzbuqVar.getPosition();
                    int zzalm = zzbuqVar.zzalm();
                    if (zzalm != 0 && zzalm != 1 && zzalm != 1000) {
                        zzbuqVar.zzgc(position);
                        zza(zzbuqVar, zzaku);
                        break;
                    } else {
                        this.zzchr = zzvc.zzcd(zzalm);
                        break;
                    }
                case 106:
                    if (this.zzchs == null) {
                        this.zzchs = new zzvq();
                    }
                    zzbuqVar.zza(this.zzchs);
                    break;
                case 112:
                    int zzb = zzbvc.zzb(zzbuqVar, 112);
                    long[] jArr = this.zzcht;
                    int length = jArr == null ? 0 : jArr.length;
                    long[] jArr2 = new long[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzcht, 0, jArr2, 0, length);
                    }
                    while (length < jArr2.length - 1) {
                        jArr2[length] = zzbuqVar.zzaln();
                        zzbuqVar.zzaku();
                        length++;
                    }
                    jArr2[length] = zzbuqVar.zzaln();
                    this.zzcht = jArr2;
                    break;
                case 114:
                    int zzer = zzbuqVar.zzer(zzbuqVar.zzalm());
                    int position2 = zzbuqVar.getPosition();
                    int i = 0;
                    while (zzbuqVar.zzapl() > 0) {
                        zzbuqVar.zzaln();
                        i++;
                    }
                    zzbuqVar.zzgc(position2);
                    long[] jArr3 = this.zzcht;
                    int length2 = jArr3 == null ? 0 : jArr3.length;
                    long[] jArr4 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzcht, 0, jArr4, 0, length2);
                    }
                    while (length2 < jArr4.length) {
                        jArr4[length2] = zzbuqVar.zzaln();
                        length2++;
                    }
                    this.zzcht = jArr4;
                    zzbuqVar.zzes(zzer);
                    break;
                case 122:
                    if (this.zzchu == null) {
                        this.zzchu = new zzvn();
                    }
                    zzbuqVar.zza(this.zzchu);
                    break;
                case 130:
                    if (this.zzchv == null) {
                        this.zzchv = new zzvo();
                    }
                    zzbuqVar.zza(this.zzchv);
                    break;
                case 138:
                    this.zzchw = (zzuw.zzh) zzbuqVar.zza(zzuw.zzh.zzon());
                    break;
                case 146:
                    if (this.zzchx == null) {
                        this.zzchx = new zzvl();
                    }
                    zzbuqVar.zza(this.zzchx);
                    break;
                default:
                    if (!super.zza(zzbuqVar, zzaku)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
