package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfk extends zzyc<zzfk> {
    private static volatile zzfk[] zzavp;
    public zzfn zzavq = null;
    public zzfl zzavr = null;
    public Boolean zzavs = null;
    public String zzavt = null;

    public zzfk() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzfk[] zzmt() {
        if (zzavp == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavp == null) {
                    zzavp = new zzfk[0];
                }
            }
        }
        return zzavp;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfk)) {
            return false;
        }
        zzfk zzfkVar = (zzfk) obj;
        zzfn zzfnVar = this.zzavq;
        if (zzfnVar == null) {
            if (zzfkVar.zzavq != null) {
                return false;
            }
        } else if (!zzfnVar.equals(zzfkVar.zzavq)) {
            return false;
        }
        zzfl zzflVar = this.zzavr;
        if (zzflVar == null) {
            if (zzfkVar.zzavr != null) {
                return false;
            }
        } else if (!zzflVar.equals(zzfkVar.zzavr)) {
            return false;
        }
        Boolean bool = this.zzavs;
        if (bool == null) {
            if (zzfkVar.zzavs != null) {
                return false;
            }
        } else if (!bool.equals(zzfkVar.zzavs)) {
            return false;
        }
        String str = this.zzavt;
        if (str == null) {
            if (zzfkVar.zzavt != null) {
                return false;
            }
        } else if (!str.equals(zzfkVar.zzavt)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfkVar.zzcet);
        }
        zzye zzyeVar2 = zzfkVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = zzfk.class.getName().hashCode() + 527;
        zzfn zzfnVar = this.zzavq;
        int i = 0;
        int hashCode2 = (hashCode * 31) + (zzfnVar == null ? 0 : zzfnVar.hashCode());
        zzfl zzflVar = this.zzavr;
        int hashCode3 = ((hashCode2 * 31) + (zzflVar == null ? 0 : zzflVar.hashCode())) * 31;
        Boolean bool = this.zzavs;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.zzavt;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        zzfn zzfnVar = this.zzavq;
        if (zzfnVar != null) {
            zzyaVar.zza(1, zzfnVar);
        }
        zzfl zzflVar = this.zzavr;
        if (zzflVar != null) {
            zzyaVar.zza(2, zzflVar);
        }
        Boolean bool = this.zzavs;
        if (bool != null) {
            zzyaVar.zzb(3, bool.booleanValue());
        }
        String str = this.zzavt;
        if (str != null) {
            zzyaVar.zzb(4, str);
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int zzf = super.zzf();
        zzfn zzfnVar = this.zzavq;
        if (zzfnVar != null) {
            zzf += zzya.zzb(1, zzfnVar);
        }
        zzfl zzflVar = this.zzavr;
        if (zzflVar != null) {
            zzf += zzya.zzb(2, zzflVar);
        }
        Boolean bool = this.zzavs;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(3) + 1;
        }
        String str = this.zzavt;
        return str != null ? zzf + zzya.zzc(4, str) : zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                if (this.zzavq == null) {
                    this.zzavq = new zzfn();
                }
                zzxzVar.zza(this.zzavq);
            } else if (zzuj == 18) {
                if (this.zzavr == null) {
                    this.zzavr = new zzfl();
                }
                zzxzVar.zza(this.zzavr);
            } else if (zzuj == 24) {
                this.zzavs = Boolean.valueOf(zzxzVar.zzup());
            } else if (zzuj != 34) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                this.zzavt = zzxzVar.readString();
            }
        }
    }
}
