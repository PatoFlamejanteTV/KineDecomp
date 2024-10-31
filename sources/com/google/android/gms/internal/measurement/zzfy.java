package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfy extends zzyc<zzfy> {
    private static volatile zzfy[] zzayr;
    public Integer zzawx = null;
    public long[] zzays = zzyl.zzcfi;

    public zzfy() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzfy[] zznc() {
        if (zzayr == null) {
            synchronized (zzyg.zzcfc) {
                if (zzayr == null) {
                    zzayr = new zzfy[0];
                }
            }
        }
        return zzayr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfy)) {
            return false;
        }
        zzfy zzfyVar = (zzfy) obj;
        Integer num = this.zzawx;
        if (num == null) {
            if (zzfyVar.zzawx != null) {
                return false;
            }
        } else if (!num.equals(zzfyVar.zzawx)) {
            return false;
        }
        if (!zzyg.equals(this.zzays, zzfyVar.zzays)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfyVar.zzcet);
        }
        zzye zzyeVar2 = zzfyVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfy.class.getName().hashCode() + 527) * 31;
        Integer num = this.zzawx;
        int i = 0;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zzyg.hashCode(this.zzays)) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        Integer num = this.zzawx;
        if (num != null) {
            zzyaVar.zzd(1, num.intValue());
        }
        long[] jArr = this.zzays;
        if (jArr != null && jArr.length > 0) {
            int i = 0;
            while (true) {
                long[] jArr2 = this.zzays;
                if (i >= jArr2.length) {
                    break;
                }
                zzyaVar.zzi(2, jArr2[i]);
                i++;
            }
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzawx;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        long[] jArr = this.zzays;
        if (jArr == null || jArr.length <= 0) {
            return zzf;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            long[] jArr2 = this.zzays;
            if (i < jArr2.length) {
                i2 += zzya.zzbg(jArr2[i]);
                i++;
            } else {
                return zzf + i2 + (jArr2.length * 1);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzawx = Integer.valueOf(zzxzVar.zzvb());
            } else if (zzuj == 16) {
                int zzb = zzyl.zzb(zzxzVar, 16);
                long[] jArr = this.zzays;
                int length = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzays, 0, jArr2, 0, length);
                }
                while (length < jArr2.length - 1) {
                    jArr2[length] = zzxzVar.zzvc();
                    zzxzVar.zzuj();
                    length++;
                }
                jArr2[length] = zzxzVar.zzvc();
                this.zzays = jArr2;
            } else if (zzuj != 18) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                int zzas = zzxzVar.zzas(zzxzVar.zzvb());
                int position = zzxzVar.getPosition();
                int i = 0;
                while (zzxzVar.zzyy() > 0) {
                    zzxzVar.zzvc();
                    i++;
                }
                zzxzVar.zzcb(position);
                long[] jArr3 = this.zzays;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.zzays, 0, jArr4, 0, length2);
                }
                while (length2 < jArr4.length) {
                    jArr4[length2] = zzxzVar.zzvc();
                    length2++;
                }
                this.zzays = jArr4;
                zzxzVar.zzat(zzas);
            }
        }
    }
}
