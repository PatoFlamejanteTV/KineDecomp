package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuw;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzvn extends zzbut<zzvn> {
    public String zzchc = null;
    private zzuw.zzn zzchd = null;
    private Integer zzche = null;
    public zzvq zzchf = null;
    private Integer zzchg = null;
    private zzvc zzchh = null;
    private zzvc zzchi = null;
    private zzvc zzchj = null;

    public zzvn() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        String str = this.zzchc;
        if (str != null) {
            zzburVar.zzf(1, str);
        }
        zzuw.zzn zznVar = this.zzchd;
        if (zznVar != null) {
            zzburVar.zze(2, zznVar);
        }
        Integer num = this.zzche;
        if (num != null) {
            zzburVar.zzv(3, num.intValue());
        }
        zzvq zzvqVar = this.zzchf;
        if (zzvqVar != null) {
            zzburVar.zza(4, zzvqVar);
        }
        Integer num2 = this.zzchg;
        if (num2 != null) {
            zzburVar.zzv(5, num2.intValue());
        }
        zzvc zzvcVar = this.zzchh;
        if (zzvcVar != null && zzvcVar != null) {
            zzburVar.zzv(6, zzvcVar.zzom());
        }
        zzvc zzvcVar2 = this.zzchi;
        if (zzvcVar2 != null && zzvcVar2 != null) {
            zzburVar.zzv(7, zzvcVar2.zzom());
        }
        zzvc zzvcVar3 = this.zzchj;
        if (zzvcVar3 != null && zzvcVar3 != null) {
            zzburVar.zzv(8, zzvcVar3.zzom());
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        String str = this.zzchc;
        if (str != null) {
            zzt += zzbur.zzg(1, str);
        }
        zzuw.zzn zznVar = this.zzchd;
        if (zznVar != null) {
            zzt += zzbqk.zzc(2, zznVar);
        }
        Integer num = this.zzche;
        if (num != null) {
            zzt += zzbur.zzz(3, num.intValue());
        }
        zzvq zzvqVar = this.zzchf;
        if (zzvqVar != null) {
            zzt += zzbur.zzb(4, zzvqVar);
        }
        Integer num2 = this.zzchg;
        if (num2 != null) {
            zzt += zzbur.zzz(5, num2.intValue());
        }
        zzvc zzvcVar = this.zzchh;
        if (zzvcVar != null && zzvcVar != null) {
            zzt += zzbur.zzz(6, zzvcVar.zzom());
        }
        zzvc zzvcVar2 = this.zzchi;
        if (zzvcVar2 != null && zzvcVar2 != null) {
            zzt += zzbur.zzz(7, zzvcVar2.zzom());
        }
        zzvc zzvcVar3 = this.zzchj;
        return (zzvcVar3 == null || zzvcVar3 == null) ? zzt : zzt + zzbur.zzz(8, zzvcVar3.zzom());
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                this.zzchc = zzbuqVar.readString();
            } else if (zzaku == 18) {
                this.zzchd = (zzuw.zzn) zzbuqVar.zza(zzuw.zzn.zzon());
            } else if (zzaku == 24) {
                this.zzche = Integer.valueOf(zzbuqVar.zzalm());
            } else if (zzaku == 34) {
                if (this.zzchf == null) {
                    this.zzchf = new zzvq();
                }
                zzbuqVar.zza(this.zzchf);
            } else if (zzaku == 40) {
                this.zzchg = Integer.valueOf(zzbuqVar.zzalm());
            } else if (zzaku == 48) {
                int position = zzbuqVar.getPosition();
                int zzalm = zzbuqVar.zzalm();
                if (zzalm != 0 && zzalm != 1 && zzalm != 1000) {
                    zzbuqVar.zzgc(position);
                    zza(zzbuqVar, zzaku);
                } else {
                    this.zzchh = zzvc.zzcd(zzalm);
                }
            } else if (zzaku == 56) {
                int position2 = zzbuqVar.getPosition();
                int zzalm2 = zzbuqVar.zzalm();
                if (zzalm2 != 0 && zzalm2 != 1 && zzalm2 != 1000) {
                    zzbuqVar.zzgc(position2);
                    zza(zzbuqVar, zzaku);
                } else {
                    this.zzchi = zzvc.zzcd(zzalm2);
                }
            } else if (zzaku != 64) {
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
                    this.zzchj = zzvc.zzcd(zzalm3);
                }
            }
        }
    }
}
