package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzft extends zzyc<zzft> {
    private static volatile zzft[] zzawz;
    public zzfu[] zzaxa = zzfu.zzna();
    public String name = null;
    public Long zzaxb = null;
    public Long zzaxc = null;
    public Integer count = null;

    public zzft() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzft[] zzmz() {
        if (zzawz == null) {
            synchronized (zzyg.zzcfc) {
                if (zzawz == null) {
                    zzawz = new zzft[0];
                }
            }
        }
        return zzawz;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzftVar = (zzft) obj;
        if (!zzyg.equals(this.zzaxa, zzftVar.zzaxa)) {
            return false;
        }
        String str = this.name;
        if (str == null) {
            if (zzftVar.name != null) {
                return false;
            }
        } else if (!str.equals(zzftVar.name)) {
            return false;
        }
        Long l = this.zzaxb;
        if (l == null) {
            if (zzftVar.zzaxb != null) {
                return false;
            }
        } else if (!l.equals(zzftVar.zzaxb)) {
            return false;
        }
        Long l2 = this.zzaxc;
        if (l2 == null) {
            if (zzftVar.zzaxc != null) {
                return false;
            }
        } else if (!l2.equals(zzftVar.zzaxc)) {
            return false;
        }
        Integer num = this.count;
        if (num == null) {
            if (zzftVar.count != null) {
                return false;
            }
        } else if (!num.equals(zzftVar.count)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzftVar.zzcet);
        }
        zzye zzyeVar2 = zzftVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (((zzft.class.getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzaxa)) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.zzaxb;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.zzaxc;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num = this.count;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        zzfu[] zzfuVarArr = this.zzaxa;
        if (zzfuVarArr != null && zzfuVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzfu[] zzfuVarArr2 = this.zzaxa;
                if (i >= zzfuVarArr2.length) {
                    break;
                }
                zzfu zzfuVar = zzfuVarArr2[i];
                if (zzfuVar != null) {
                    zzyaVar.zza(1, zzfuVar);
                }
                i++;
            }
        }
        String str = this.name;
        if (str != null) {
            zzyaVar.zzb(2, str);
        }
        Long l = this.zzaxb;
        if (l != null) {
            zzyaVar.zzi(3, l.longValue());
        }
        Long l2 = this.zzaxc;
        if (l2 != null) {
            zzyaVar.zzi(4, l2.longValue());
        }
        Integer num = this.count;
        if (num != null) {
            zzyaVar.zzd(5, num.intValue());
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int zzf = super.zzf();
        zzfu[] zzfuVarArr = this.zzaxa;
        if (zzfuVarArr != null && zzfuVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzfu[] zzfuVarArr2 = this.zzaxa;
                if (i >= zzfuVarArr2.length) {
                    break;
                }
                zzfu zzfuVar = zzfuVarArr2[i];
                if (zzfuVar != null) {
                    zzf += zzya.zzb(1, zzfuVar);
                }
                i++;
            }
        }
        String str = this.name;
        if (str != null) {
            zzf += zzya.zzc(2, str);
        }
        Long l = this.zzaxb;
        if (l != null) {
            zzf += zzya.zzd(3, l.longValue());
        }
        Long l2 = this.zzaxc;
        if (l2 != null) {
            zzf += zzya.zzd(4, l2.longValue());
        }
        Integer num = this.count;
        return num != null ? zzf + zzya.zzh(5, num.intValue()) : zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                int zzb = zzyl.zzb(zzxzVar, 10);
                zzfu[] zzfuVarArr = this.zzaxa;
                int length = zzfuVarArr == null ? 0 : zzfuVarArr.length;
                zzfu[] zzfuVarArr2 = new zzfu[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzaxa, 0, zzfuVarArr2, 0, length);
                }
                while (length < zzfuVarArr2.length - 1) {
                    zzfuVarArr2[length] = new zzfu();
                    zzxzVar.zza(zzfuVarArr2[length]);
                    zzxzVar.zzuj();
                    length++;
                }
                zzfuVarArr2[length] = new zzfu();
                zzxzVar.zza(zzfuVarArr2[length]);
                this.zzaxa = zzfuVarArr2;
            } else if (zzuj == 18) {
                this.name = zzxzVar.readString();
            } else if (zzuj == 24) {
                this.zzaxb = Long.valueOf(zzxzVar.zzvc());
            } else if (zzuj == 32) {
                this.zzaxc = Long.valueOf(zzxzVar.zzvc());
            } else if (zzuj != 40) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                this.count = Integer.valueOf(zzxzVar.zzvb());
            }
        }
    }
}
