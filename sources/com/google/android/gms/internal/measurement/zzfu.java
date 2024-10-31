package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfu extends zzyc<zzfu> {
    private static volatile zzfu[] zzaxd;
    public String name = null;
    public String zzaml = null;
    public Long zzaxe = null;
    private Float zzaum = null;
    public Double zzaun = null;

    public zzfu() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzfu[] zzna() {
        if (zzaxd == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaxd == null) {
                    zzaxd = new zzfu[0];
                }
            }
        }
        return zzaxd;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfu)) {
            return false;
        }
        zzfu zzfuVar = (zzfu) obj;
        String str = this.name;
        if (str == null) {
            if (zzfuVar.name != null) {
                return false;
            }
        } else if (!str.equals(zzfuVar.name)) {
            return false;
        }
        String str2 = this.zzaml;
        if (str2 == null) {
            if (zzfuVar.zzaml != null) {
                return false;
            }
        } else if (!str2.equals(zzfuVar.zzaml)) {
            return false;
        }
        Long l = this.zzaxe;
        if (l == null) {
            if (zzfuVar.zzaxe != null) {
                return false;
            }
        } else if (!l.equals(zzfuVar.zzaxe)) {
            return false;
        }
        Float f2 = this.zzaum;
        if (f2 == null) {
            if (zzfuVar.zzaum != null) {
                return false;
            }
        } else if (!f2.equals(zzfuVar.zzaum)) {
            return false;
        }
        Double d2 = this.zzaun;
        if (d2 == null) {
            if (zzfuVar.zzaun != null) {
                return false;
            }
        } else if (!d2.equals(zzfuVar.zzaun)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfuVar.zzcet);
        }
        zzye zzyeVar2 = zzfuVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfu.class.getName().hashCode() + 527) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzaml;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.zzaxe;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Float f2 = this.zzaum;
        int hashCode5 = (hashCode4 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Double d2 = this.zzaun;
        int hashCode6 = (hashCode5 + (d2 == null ? 0 : d2.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode6 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        String str = this.name;
        if (str != null) {
            zzyaVar.zzb(1, str);
        }
        String str2 = this.zzaml;
        if (str2 != null) {
            zzyaVar.zzb(2, str2);
        }
        Long l = this.zzaxe;
        if (l != null) {
            zzyaVar.zzi(3, l.longValue());
        }
        Float f2 = this.zzaum;
        if (f2 != null) {
            zzyaVar.zza(4, f2.floatValue());
        }
        Double d2 = this.zzaun;
        if (d2 != null) {
            zzyaVar.zza(5, d2.doubleValue());
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int zzf = super.zzf();
        String str = this.name;
        if (str != null) {
            zzf += zzya.zzc(1, str);
        }
        String str2 = this.zzaml;
        if (str2 != null) {
            zzf += zzya.zzc(2, str2);
        }
        Long l = this.zzaxe;
        if (l != null) {
            zzf += zzya.zzd(3, l.longValue());
        }
        Float f2 = this.zzaum;
        if (f2 != null) {
            f2.floatValue();
            zzf += zzya.zzbd(4) + 4;
        }
        Double d2 = this.zzaun;
        if (d2 == null) {
            return zzf;
        }
        d2.doubleValue();
        return zzf + zzya.zzbd(5) + 8;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                this.name = zzxzVar.readString();
            } else if (zzuj == 18) {
                this.zzaml = zzxzVar.readString();
            } else if (zzuj == 24) {
                this.zzaxe = Long.valueOf(zzxzVar.zzvc());
            } else if (zzuj == 37) {
                this.zzaum = Float.valueOf(Float.intBitsToFloat(zzxzVar.zzvd()));
            } else if (zzuj != 41) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                this.zzaun = Double.valueOf(Double.longBitsToDouble(zzxzVar.zzve()));
            }
        }
    }
}
