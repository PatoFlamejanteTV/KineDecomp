package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuw;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzvl extends zzbut<zzvl> {
    public Integer zzcgm = null;
    private zzvc zzcgn = null;
    private zzuw.zzb zzcgo = null;
    public zzvm zzcgp = null;
    private zzuw.zza[] zzcgq = new zzuw.zza[0];
    private zzuw.zzc zzcgr = null;
    private zzuw.zzj zzcgs = null;
    private zzuw.zzi zzcgt = null;
    private zzuw.zzf zzcgu = null;
    private zzuw.zzg zzcgv = null;
    private zzvr[] zzcgw = zzvr.zzpl();

    public zzvl() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    private final zzvl zze(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            switch (zzaku) {
                case 0:
                    return this;
                case 56:
                    int position = zzbuqVar.getPosition();
                    try {
                        int zzalm = zzbuqVar.zzalm();
                        if (zzalm >= 0 && zzalm <= 9) {
                            this.zzcgm = Integer.valueOf(zzalm);
                            break;
                        } else {
                            StringBuilder sb = new StringBuilder(43);
                            sb.append(zzalm);
                            sb.append(" is not a valid enum AdInitiater");
                            throw new IllegalArgumentException(sb.toString());
                            break;
                        }
                    } catch (IllegalArgumentException unused) {
                        zzbuqVar.zzgc(position);
                        zza(zzbuqVar, zzaku);
                        break;
                    }
                case 64:
                    int position2 = zzbuqVar.getPosition();
                    int zzalm2 = zzbuqVar.zzalm();
                    if (zzalm2 != 0 && zzalm2 != 1 && zzalm2 != 1000) {
                        zzbuqVar.zzgc(position2);
                        zza(zzbuqVar, zzaku);
                        break;
                    } else {
                        this.zzcgn = zzvc.zzcd(zzalm2);
                        break;
                    }
                case 74:
                    this.zzcgo = (zzuw.zzb) zzbuqVar.zza(zzuw.zzb.zzon());
                    break;
                case 82:
                    if (this.zzcgp == null) {
                        this.zzcgp = new zzvm();
                    }
                    zzbuqVar.zza(this.zzcgp);
                    break;
                case 90:
                    int zzb = zzbvc.zzb(zzbuqVar, 90);
                    zzuw.zza[] zzaVarArr = this.zzcgq;
                    int length = zzaVarArr == null ? 0 : zzaVarArr.length;
                    zzuw.zza[] zzaVarArr2 = new zzuw.zza[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzcgq, 0, zzaVarArr2, 0, length);
                    }
                    while (length < zzaVarArr2.length - 1) {
                        zzaVarArr2[length] = (zzuw.zza) zzbuqVar.zza(zzuw.zza.zzon());
                        zzbuqVar.zzaku();
                        length++;
                    }
                    zzaVarArr2[length] = (zzuw.zza) zzbuqVar.zza(zzuw.zza.zzon());
                    this.zzcgq = zzaVarArr2;
                    break;
                case 98:
                    this.zzcgr = (zzuw.zzc) zzbuqVar.zza(zzuw.zzc.zzon());
                    break;
                case 106:
                    this.zzcgs = (zzuw.zzj) zzbuqVar.zza(zzuw.zzj.zzon());
                    break;
                case 114:
                    this.zzcgt = (zzuw.zzi) zzbuqVar.zza(zzuw.zzi.zzon());
                    break;
                case 122:
                    this.zzcgu = (zzuw.zzf) zzbuqVar.zza(zzuw.zzf.zzon());
                    break;
                case 130:
                    this.zzcgv = (zzuw.zzg) zzbuqVar.zza(zzuw.zzg.zzon());
                    break;
                case 138:
                    int zzb2 = zzbvc.zzb(zzbuqVar, 138);
                    zzvr[] zzvrVarArr = this.zzcgw;
                    int length2 = zzvrVarArr == null ? 0 : zzvrVarArr.length;
                    zzvr[] zzvrVarArr2 = new zzvr[zzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzcgw, 0, zzvrVarArr2, 0, length2);
                    }
                    while (length2 < zzvrVarArr2.length - 1) {
                        zzvrVarArr2[length2] = new zzvr();
                        zzbuqVar.zza(zzvrVarArr2[length2]);
                        zzbuqVar.zzaku();
                        length2++;
                    }
                    zzvrVarArr2[length2] = new zzvr();
                    zzbuqVar.zza(zzvrVarArr2[length2]);
                    this.zzcgw = zzvrVarArr2;
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
        Integer num = this.zzcgm;
        if (num != null) {
            zzburVar.zzv(7, num.intValue());
        }
        zzvc zzvcVar = this.zzcgn;
        if (zzvcVar != null && zzvcVar != null) {
            zzburVar.zzv(8, zzvcVar.zzom());
        }
        zzuw.zzb zzbVar = this.zzcgo;
        if (zzbVar != null) {
            zzburVar.zze(9, zzbVar);
        }
        zzvm zzvmVar = this.zzcgp;
        if (zzvmVar != null) {
            zzburVar.zza(10, zzvmVar);
        }
        zzuw.zza[] zzaVarArr = this.zzcgq;
        int i = 0;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzuw.zza[] zzaVarArr2 = this.zzcgq;
                if (i2 >= zzaVarArr2.length) {
                    break;
                }
                zzuw.zza zzaVar = zzaVarArr2[i2];
                if (zzaVar != null) {
                    zzburVar.zze(11, zzaVar);
                }
                i2++;
            }
        }
        zzuw.zzc zzcVar = this.zzcgr;
        if (zzcVar != null) {
            zzburVar.zze(12, zzcVar);
        }
        zzuw.zzj zzjVar = this.zzcgs;
        if (zzjVar != null) {
            zzburVar.zze(13, zzjVar);
        }
        zzuw.zzi zziVar = this.zzcgt;
        if (zziVar != null) {
            zzburVar.zze(14, zziVar);
        }
        zzuw.zzf zzfVar = this.zzcgu;
        if (zzfVar != null) {
            zzburVar.zze(15, zzfVar);
        }
        zzuw.zzg zzgVar = this.zzcgv;
        if (zzgVar != null) {
            zzburVar.zze(16, zzgVar);
        }
        zzvr[] zzvrVarArr = this.zzcgw;
        if (zzvrVarArr != null && zzvrVarArr.length > 0) {
            while (true) {
                zzvr[] zzvrVarArr2 = this.zzcgw;
                if (i >= zzvrVarArr2.length) {
                    break;
                }
                zzvr zzvrVar = zzvrVarArr2[i];
                if (zzvrVar != null) {
                    zzburVar.zza(17, zzvrVar);
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
        Integer num = this.zzcgm;
        if (num != null) {
            zzt += zzbur.zzz(7, num.intValue());
        }
        zzvc zzvcVar = this.zzcgn;
        if (zzvcVar != null && zzvcVar != null) {
            zzt += zzbur.zzz(8, zzvcVar.zzom());
        }
        zzuw.zzb zzbVar = this.zzcgo;
        if (zzbVar != null) {
            zzt += zzbqk.zzc(9, zzbVar);
        }
        zzvm zzvmVar = this.zzcgp;
        if (zzvmVar != null) {
            zzt += zzbur.zzb(10, zzvmVar);
        }
        zzuw.zza[] zzaVarArr = this.zzcgq;
        int i = 0;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i2 = zzt;
            int i3 = 0;
            while (true) {
                zzuw.zza[] zzaVarArr2 = this.zzcgq;
                if (i3 >= zzaVarArr2.length) {
                    break;
                }
                zzuw.zza zzaVar = zzaVarArr2[i3];
                if (zzaVar != null) {
                    i2 += zzbqk.zzc(11, zzaVar);
                }
                i3++;
            }
            zzt = i2;
        }
        zzuw.zzc zzcVar = this.zzcgr;
        if (zzcVar != null) {
            zzt += zzbqk.zzc(12, zzcVar);
        }
        zzuw.zzj zzjVar = this.zzcgs;
        if (zzjVar != null) {
            zzt += zzbqk.zzc(13, zzjVar);
        }
        zzuw.zzi zziVar = this.zzcgt;
        if (zziVar != null) {
            zzt += zzbqk.zzc(14, zziVar);
        }
        zzuw.zzf zzfVar = this.zzcgu;
        if (zzfVar != null) {
            zzt += zzbqk.zzc(15, zzfVar);
        }
        zzuw.zzg zzgVar = this.zzcgv;
        if (zzgVar != null) {
            zzt += zzbqk.zzc(16, zzgVar);
        }
        zzvr[] zzvrVarArr = this.zzcgw;
        if (zzvrVarArr != null && zzvrVarArr.length > 0) {
            while (true) {
                zzvr[] zzvrVarArr2 = this.zzcgw;
                if (i >= zzvrVarArr2.length) {
                    break;
                }
                zzvr zzvrVar = zzvrVarArr2[i];
                if (zzvrVar != null) {
                    zzt += zzbur.zzb(17, zzvrVar);
                }
                i++;
            }
        }
        return zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        zze(zzbuqVar);
        return this;
    }
}
