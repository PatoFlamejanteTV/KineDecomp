package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuw;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzvs extends zzbut<zzvs> {
    private zzvq zzcis = null;
    private zzvc zzcit = null;
    private zzuw.zzq zzciu = null;
    private zzuw.zzn zzciv = null;

    public zzvs() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzburVar) throws IOException {
        zzvq zzvqVar = this.zzcis;
        if (zzvqVar != null) {
            zzburVar.zza(1, zzvqVar);
        }
        zzvc zzvcVar = this.zzcit;
        if (zzvcVar != null && zzvcVar != null) {
            zzburVar.zzv(2, zzvcVar.zzom());
        }
        zzuw.zzq zzqVar = this.zzciu;
        if (zzqVar != null) {
            zzburVar.zze(3, zzqVar);
        }
        zzuw.zzn zznVar = this.zzciv;
        if (zznVar != null) {
            zzburVar.zze(4, zznVar);
        }
        super.zza(zzburVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        zzvq zzvqVar = this.zzcis;
        if (zzvqVar != null) {
            zzt += zzbur.zzb(1, zzvqVar);
        }
        zzvc zzvcVar = this.zzcit;
        if (zzvcVar != null && zzvcVar != null) {
            zzt += zzbur.zzz(2, zzvcVar.zzom());
        }
        zzuw.zzq zzqVar = this.zzciu;
        if (zzqVar != null) {
            zzt += zzbqk.zzc(3, zzqVar);
        }
        zzuw.zzn zznVar = this.zzciv;
        return zznVar != null ? zzt + zzbqk.zzc(4, zznVar) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuqVar) throws IOException {
        while (true) {
            int zzaku = zzbuqVar.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                if (this.zzcis == null) {
                    this.zzcis = new zzvq();
                }
                zzbuqVar.zza(this.zzcis);
            } else if (zzaku == 16) {
                int position = zzbuqVar.getPosition();
                int zzalm = zzbuqVar.zzalm();
                if (zzalm != 0 && zzalm != 1 && zzalm != 1000) {
                    zzbuqVar.zzgc(position);
                    zza(zzbuqVar, zzaku);
                } else {
                    this.zzcit = zzvc.zzcd(zzalm);
                }
            } else if (zzaku == 26) {
                this.zzciu = (zzuw.zzq) zzbuqVar.zza(zzuw.zzq.zzon());
            } else if (zzaku != 34) {
                if (!super.zza(zzbuqVar, zzaku)) {
                    return this;
                }
            } else {
                this.zzciv = (zzuw.zzn) zzbuqVar.zza(zzuw.zzn.zzon());
            }
        }
    }
}
