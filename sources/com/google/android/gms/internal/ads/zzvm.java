package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuw;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzvm extends zzbut<zzvm> {
    public String zzcgx = null;
    private zzuw.zza[] zzcgy = new zzuw.zza[0];
    private zzvc zzcgz = null;
    private zzvc zzcha = null;
    private zzvc zzchb = null;

    public zzvm() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        String str = this.zzcgx;
        if (str != null) {
            zzburVar.zzf(1, str);
        }
        zzuw.zza[] zzaVarArr = this.zzcgy;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzuw.zza[] zzaVarArr2 = this.zzcgy;
                if (i >= zzaVarArr2.length) {
                    break;
                }
                zzuw.zza zzaVar = zzaVarArr2[i];
                if (zzaVar != null) {
                    zzburVar.zze(2, zzaVar);
                }
                i++;
            }
        }
        zzvc zzvcVar = this.zzcgz;
        if (zzvcVar != null && zzvcVar != null) {
            zzburVar.zzv(3, zzvcVar.zzom());
        }
        zzvc zzvcVar2 = this.zzcha;
        if (zzvcVar2 != null && zzvcVar2 != null) {
            zzburVar.zzv(4, zzvcVar2.zzom());
        }
        zzvc zzvcVar3 = this.zzchb;
        if (zzvcVar3 != null && zzvcVar3 != null) {
            zzburVar.zzv(5, zzvcVar3.zzom());
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        String str = this.zzcgx;
        if (str != null) {
            zzt += zzbur.zzg(1, str);
        }
        zzuw.zza[] zzaVarArr = this.zzcgy;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzuw.zza[] zzaVarArr2 = this.zzcgy;
                if (i >= zzaVarArr2.length) {
                    break;
                }
                zzuw.zza zzaVar = zzaVarArr2[i];
                if (zzaVar != null) {
                    zzt += zzbqk.zzc(2, zzaVar);
                }
                i++;
            }
        }
        zzvc zzvcVar = this.zzcgz;
        if (zzvcVar != null && zzvcVar != null) {
            zzt += zzbur.zzz(3, zzvcVar.zzom());
        }
        zzvc zzvcVar2 = this.zzcha;
        if (zzvcVar2 != null && zzvcVar2 != null) {
            zzt += zzbur.zzz(4, zzvcVar2.zzom());
        }
        zzvc zzvcVar3 = this.zzchb;
        return (zzvcVar3 == null || zzvcVar3 == null) ? zzt : zzt + zzbur.zzz(5, zzvcVar3.zzom());
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                this.zzcgx = zzbuqVar.readString();
            } else if (zzaku == 18) {
                int zzb = zzbvc.zzb(zzbuqVar, 18);
                zzuw.zza[] zzaVarArr = this.zzcgy;
                int length = zzaVarArr == null ? 0 : zzaVarArr.length;
                zzuw.zza[] zzaVarArr2 = new zzuw.zza[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzcgy, 0, zzaVarArr2, 0, length);
                }
                while (length < zzaVarArr2.length - 1) {
                    zzaVarArr2[length] = (zzuw.zza) zzbuqVar.zza(zzuw.zza.zzon());
                    zzbuqVar.zzaku();
                    length++;
                }
                zzaVarArr2[length] = (zzuw.zza) zzbuqVar.zza(zzuw.zza.zzon());
                this.zzcgy = zzaVarArr2;
            } else if (zzaku == 24) {
                int position = zzbuqVar.getPosition();
                int zzalm = zzbuqVar.zzalm();
                if (zzalm != 0 && zzalm != 1 && zzalm != 1000) {
                    zzbuqVar.zzgc(position);
                    zza(zzbuqVar, zzaku);
                } else {
                    this.zzcgz = zzvc.zzcd(zzalm);
                }
            } else if (zzaku == 32) {
                int position2 = zzbuqVar.getPosition();
                int zzalm2 = zzbuqVar.zzalm();
                if (zzalm2 != 0 && zzalm2 != 1 && zzalm2 != 1000) {
                    zzbuqVar.zzgc(position2);
                    zza(zzbuqVar, zzaku);
                } else {
                    this.zzcha = zzvc.zzcd(zzalm2);
                }
            } else if (zzaku != 40) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                int position3 = zzbuqVar.getPosition();
                int zzalm3 = zzbuqVar.zzalm();
                if (zzalm3 != 0 && zzalm3 != 1 && zzalm3 != 1000) {
                    zzbuqVar.zzgc(position3);
                    zza(zzbuqVar, zzaku);
                } else {
                    this.zzchb = zzvc.zzcd(zzalm3);
                }
            }
        }
    }
}
