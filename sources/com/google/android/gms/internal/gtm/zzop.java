package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzop extends zzuq<zzop> {
    public long zzaux = 0;
    public zzi zzqk = null;
    public zzk zzauy = null;

    public zzop() {
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzop)) {
            return false;
        }
        zzop zzopVar = (zzop) obj;
        if (this.zzaux != zzopVar.zzaux) {
            return false;
        }
        zzi zziVar = this.zzqk;
        if (zziVar == null) {
            if (zzopVar.zzqk != null) {
                return false;
            }
        } else if (!zziVar.equals(zzopVar.zzqk)) {
            return false;
        }
        zzk zzkVar = this.zzauy;
        if (zzkVar == null) {
            if (zzopVar.zzauy != null) {
                return false;
            }
        } else if (!zzkVar.equals(zzopVar.zzauy)) {
            return false;
        }
        zzus zzusVar = this.zzbhb;
        if (zzusVar != null && !zzusVar.isEmpty()) {
            return this.zzbhb.equals(zzopVar.zzbhb);
        }
        zzus zzusVar2 = zzopVar.zzbhb;
        return zzusVar2 == null || zzusVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzop.class.getName().hashCode() + 527) * 31;
        long j = this.zzaux;
        int i = hashCode + ((int) (j ^ (j >>> 32)));
        zzi zziVar = this.zzqk;
        int i2 = 0;
        int hashCode2 = (i * 31) + (zziVar == null ? 0 : zziVar.hashCode());
        zzk zzkVar = this.zzauy;
        int hashCode3 = ((hashCode2 * 31) + (zzkVar == null ? 0 : zzkVar.hashCode())) * 31;
        zzus zzusVar = this.zzbhb;
        if (zzusVar != null && !zzusVar.isEmpty()) {
            i2 = this.zzbhb.hashCode();
        }
        return hashCode3 + i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final void zza(zzuo zzuoVar) throws IOException {
        zzuoVar.zzi(1, this.zzaux);
        zzi zziVar = this.zzqk;
        if (zziVar != null) {
            zzuoVar.zza(2, zziVar);
        }
        zzk zzkVar = this.zzauy;
        if (zzkVar != null) {
            zzuoVar.zza(3, zzkVar);
        }
        super.zza(zzuoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zzuw
    public final int zzy() {
        int zzy = super.zzy() + zzuo.zzd(1, this.zzaux);
        zzi zziVar = this.zzqk;
        if (zziVar != null) {
            zzy += zzuo.zzb(2, zziVar);
        }
        zzk zzkVar = this.zzauy;
        return zzkVar != null ? zzy + zzuo.zzb(3, zzkVar) : zzy;
    }

    @Override // com.google.android.gms.internal.gtm.zzuw
    public final /* synthetic */ zzuw zza(zzun zzunVar) throws IOException {
        while (true) {
            int zzni = zzunVar.zzni();
            if (zzni == 0) {
                return this;
            }
            if (zzni == 8) {
                this.zzaux = zzunVar.zzob();
            } else if (zzni == 18) {
                if (this.zzqk == null) {
                    this.zzqk = new zzi();
                }
                zzunVar.zza(this.zzqk);
            } else if (zzni != 26) {
                if (!super.zza(zzunVar, zzni)) {
                    return this;
                }
            } else {
                if (this.zzauy == null) {
                    this.zzauy = new zzk();
                }
                zzunVar.zza(this.zzauy);
            }
        }
    }
}
