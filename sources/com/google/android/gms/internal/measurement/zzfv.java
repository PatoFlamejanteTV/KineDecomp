package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfv extends zzyc<zzfv> {
    public zzfw[] zzaxf = zzfw.zznb();

    public zzfv() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfv)) {
            return false;
        }
        zzfv zzfvVar = (zzfv) obj;
        if (!zzyg.equals(this.zzaxf, zzfvVar.zzaxf)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfvVar.zzcet);
        }
        zzye zzyeVar2 = zzfvVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (((zzfv.class.getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzaxf)) * 31;
        zzye zzyeVar = this.zzcet;
        return hashCode + ((zzyeVar == null || zzyeVar.isEmpty()) ? 0 : this.zzcet.hashCode());
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        zzfw[] zzfwVarArr = this.zzaxf;
        if (zzfwVarArr != null && zzfwVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzfw[] zzfwVarArr2 = this.zzaxf;
                if (i >= zzfwVarArr2.length) {
                    break;
                }
                zzfw zzfwVar = zzfwVarArr2[i];
                if (zzfwVar != null) {
                    zzyaVar.zza(1, zzfwVar);
                }
                i++;
            }
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int zzf = super.zzf();
        zzfw[] zzfwVarArr = this.zzaxf;
        if (zzfwVarArr != null && zzfwVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzfw[] zzfwVarArr2 = this.zzaxf;
                if (i >= zzfwVarArr2.length) {
                    break;
                }
                zzfw zzfwVar = zzfwVarArr2[i];
                if (zzfwVar != null) {
                    zzf += zzya.zzb(1, zzfwVar);
                }
                i++;
            }
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj != 10) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                int zzb = zzyl.zzb(zzxzVar, 10);
                zzfw[] zzfwVarArr = this.zzaxf;
                int length = zzfwVarArr == null ? 0 : zzfwVarArr.length;
                zzfw[] zzfwVarArr2 = new zzfw[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzaxf, 0, zzfwVarArr2, 0, length);
                }
                while (length < zzfwVarArr2.length - 1) {
                    zzfwVarArr2[length] = new zzfw();
                    zzxzVar.zza(zzfwVarArr2[length]);
                    zzxzVar.zzuj();
                    length++;
                }
                zzfwVarArr2[length] = new zzfw();
                zzxzVar.zza(zzfwVarArr2[length]);
                this.zzaxf = zzfwVarArr2;
            }
        }
    }
}
