package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfz extends zzyc<zzfz> {
    private static volatile zzfz[] zzayt;
    public Long zzayu = null;
    public String name = null;
    public String zzaml = null;
    public Long zzaxe = null;
    private Float zzaum = null;
    public Double zzaun = null;

    public zzfz() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzfz[] zznd() {
        if (zzayt == null) {
            synchronized (zzyg.zzcfc) {
                if (zzayt == null) {
                    zzayt = new zzfz[0];
                }
            }
        }
        return zzayt;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfz)) {
            return false;
        }
        zzfz zzfzVar = (zzfz) obj;
        Long l = this.zzayu;
        if (l == null) {
            if (zzfzVar.zzayu != null) {
                return false;
            }
        } else if (!l.equals(zzfzVar.zzayu)) {
            return false;
        }
        String str = this.name;
        if (str == null) {
            if (zzfzVar.name != null) {
                return false;
            }
        } else if (!str.equals(zzfzVar.name)) {
            return false;
        }
        String str2 = this.zzaml;
        if (str2 == null) {
            if (zzfzVar.zzaml != null) {
                return false;
            }
        } else if (!str2.equals(zzfzVar.zzaml)) {
            return false;
        }
        Long l2 = this.zzaxe;
        if (l2 == null) {
            if (zzfzVar.zzaxe != null) {
                return false;
            }
        } else if (!l2.equals(zzfzVar.zzaxe)) {
            return false;
        }
        Float f2 = this.zzaum;
        if (f2 == null) {
            if (zzfzVar.zzaum != null) {
                return false;
            }
        } else if (!f2.equals(zzfzVar.zzaum)) {
            return false;
        }
        Double d2 = this.zzaun;
        if (d2 == null) {
            if (zzfzVar.zzaun != null) {
                return false;
            }
        } else if (!d2.equals(zzfzVar.zzaun)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfzVar.zzcet);
        }
        zzye zzyeVar2 = zzfzVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfz.class.getName().hashCode() + 527) * 31;
        Long l = this.zzayu;
        int i = 0;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzaml;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l2 = this.zzaxe;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Float f2 = this.zzaum;
        int hashCode6 = (hashCode5 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Double d2 = this.zzaun;
        int hashCode7 = (hashCode6 + (d2 == null ? 0 : d2.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode7 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        Long l = this.zzayu;
        if (l != null) {
            zzyaVar.zzi(1, l.longValue());
        }
        String str = this.name;
        if (str != null) {
            zzyaVar.zzb(2, str);
        }
        String str2 = this.zzaml;
        if (str2 != null) {
            zzyaVar.zzb(3, str2);
        }
        Long l2 = this.zzaxe;
        if (l2 != null) {
            zzyaVar.zzi(4, l2.longValue());
        }
        Float f2 = this.zzaum;
        if (f2 != null) {
            zzyaVar.zza(5, f2.floatValue());
        }
        Double d2 = this.zzaun;
        if (d2 != null) {
            zzyaVar.zza(6, d2.doubleValue());
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int zzf = super.zzf();
        Long l = this.zzayu;
        if (l != null) {
            zzf += zzya.zzd(1, l.longValue());
        }
        String str = this.name;
        if (str != null) {
            zzf += zzya.zzc(2, str);
        }
        String str2 = this.zzaml;
        if (str2 != null) {
            zzf += zzya.zzc(3, str2);
        }
        Long l2 = this.zzaxe;
        if (l2 != null) {
            zzf += zzya.zzd(4, l2.longValue());
        }
        Float f2 = this.zzaum;
        if (f2 != null) {
            f2.floatValue();
            zzf += zzya.zzbd(5) + 4;
        }
        Double d2 = this.zzaun;
        if (d2 == null) {
            return zzf;
        }
        d2.doubleValue();
        return zzf + zzya.zzbd(6) + 8;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzayu = Long.valueOf(zzxzVar.zzvc());
            } else if (zzuj == 18) {
                this.name = zzxzVar.readString();
            } else if (zzuj == 26) {
                this.zzaml = zzxzVar.readString();
            } else if (zzuj == 32) {
                this.zzaxe = Long.valueOf(zzxzVar.zzvc());
            } else if (zzuj == 45) {
                this.zzaum = Float.valueOf(Float.intBitsToFloat(zzxzVar.zzvd()));
            } else if (zzuj != 49) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                this.zzaun = Double.valueOf(Double.longBitsToDouble(zzxzVar.zzve()));
            }
        }
    }
}
