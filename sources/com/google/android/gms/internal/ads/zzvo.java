package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuw;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzvo extends zzbut<zzvo> {
    private zzuw.zzd.zzb zzchk = null;
    private zzvq zzchl = null;
    private String zzchm = null;
    private String zzchn = null;

    public zzvo() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        zzuw.zzd.zzb zzbVar = this.zzchk;
        if (zzbVar != null && zzbVar != null) {
            zzburVar.zzv(5, zzbVar.zzom());
        }
        zzvq zzvqVar = this.zzchl;
        if (zzvqVar != null) {
            zzburVar.zza(6, zzvqVar);
        }
        String str = this.zzchm;
        if (str != null) {
            zzburVar.zzf(7, str);
        }
        String str2 = this.zzchn;
        if (str2 != null) {
            zzburVar.zzf(8, str2);
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        zzuw.zzd.zzb zzbVar = this.zzchk;
        if (zzbVar != null && zzbVar != null) {
            zzt += zzbur.zzz(5, zzbVar.zzom());
        }
        zzvq zzvqVar = this.zzchl;
        if (zzvqVar != null) {
            zzt += zzbur.zzb(6, zzvqVar);
        }
        String str = this.zzchm;
        if (str != null) {
            zzt += zzbur.zzg(7, str);
        }
        String str2 = this.zzchn;
        return str2 != null ? zzt + zzbur.zzg(8, str2) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 40) {
                int position = zzbuqVar.getPosition();
                int zzalm = zzbuqVar.zzalm();
                if (zzalm != 0 && zzalm != 1 && zzalm != 2) {
                    zzbuqVar.zzgc(position);
                    zza(zzbuqVar, zzaku);
                } else {
                    this.zzchk = zzuw.zzd.zzb.zzcc(zzalm);
                }
            } else if (zzaku == 50) {
                if (this.zzchl == null) {
                    this.zzchl = new zzvq();
                }
                zzbuqVar.zza(this.zzchl);
            } else if (zzaku == 58) {
                this.zzchm = zzbuqVar.readString();
            } else if (zzaku != 66) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                this.zzchn = zzbuqVar.readString();
            }
        }
    }
}
