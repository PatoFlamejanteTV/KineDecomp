package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfm extends zzyc<zzfm> {
    private static volatile zzfm[] zzavz;
    public Integer zzavk = null;
    public String zzawa = null;
    public zzfk zzawb = null;
    public Boolean zzavh = null;
    public Boolean zzavi = null;

    public zzfm() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzfm[] zzmu() {
        if (zzavz == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavz == null) {
                    zzavz = new zzfm[0];
                }
            }
        }
        return zzavz;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfm)) {
            return false;
        }
        zzfm zzfmVar = (zzfm) obj;
        Integer num = this.zzavk;
        if (num == null) {
            if (zzfmVar.zzavk != null) {
                return false;
            }
        } else if (!num.equals(zzfmVar.zzavk)) {
            return false;
        }
        String str = this.zzawa;
        if (str == null) {
            if (zzfmVar.zzawa != null) {
                return false;
            }
        } else if (!str.equals(zzfmVar.zzawa)) {
            return false;
        }
        zzfk zzfkVar = this.zzawb;
        if (zzfkVar == null) {
            if (zzfmVar.zzawb != null) {
                return false;
            }
        } else if (!zzfkVar.equals(zzfmVar.zzawb)) {
            return false;
        }
        Boolean bool = this.zzavh;
        if (bool == null) {
            if (zzfmVar.zzavh != null) {
                return false;
            }
        } else if (!bool.equals(zzfmVar.zzavh)) {
            return false;
        }
        Boolean bool2 = this.zzavi;
        if (bool2 == null) {
            if (zzfmVar.zzavi != null) {
                return false;
            }
        } else if (!bool2.equals(zzfmVar.zzavi)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfmVar.zzcet);
        }
        zzye zzyeVar2 = zzfmVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfm.class.getName().hashCode() + 527) * 31;
        Integer num = this.zzavk;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.zzawa;
        int hashCode3 = hashCode2 + (str == null ? 0 : str.hashCode());
        zzfk zzfkVar = this.zzawb;
        int hashCode4 = ((hashCode3 * 31) + (zzfkVar == null ? 0 : zzfkVar.hashCode())) * 31;
        Boolean bool = this.zzavh;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzavi;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode6 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        Integer num = this.zzavk;
        if (num != null) {
            zzyaVar.zzd(1, num.intValue());
        }
        String str = this.zzawa;
        if (str != null) {
            zzyaVar.zzb(2, str);
        }
        zzfk zzfkVar = this.zzawb;
        if (zzfkVar != null) {
            zzyaVar.zza(3, zzfkVar);
        }
        Boolean bool = this.zzavh;
        if (bool != null) {
            zzyaVar.zzb(4, bool.booleanValue());
        }
        Boolean bool2 = this.zzavi;
        if (bool2 != null) {
            zzyaVar.zzb(5, bool2.booleanValue());
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzavk;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        String str = this.zzawa;
        if (str != null) {
            zzf += zzya.zzc(2, str);
        }
        zzfk zzfkVar = this.zzawb;
        if (zzfkVar != null) {
            zzf += zzya.zzb(3, zzfkVar);
        }
        Boolean bool = this.zzavh;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(4) + 1;
        }
        Boolean bool2 = this.zzavi;
        if (bool2 == null) {
            return zzf;
        }
        bool2.booleanValue();
        return zzf + zzya.zzbd(5) + 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzavk = Integer.valueOf(zzxzVar.zzvb());
            } else if (zzuj == 18) {
                this.zzawa = zzxzVar.readString();
            } else if (zzuj == 26) {
                if (this.zzawb == null) {
                    this.zzawb = new zzfk();
                }
                zzxzVar.zza(this.zzawb);
            } else if (zzuj == 32) {
                this.zzavh = Boolean.valueOf(zzxzVar.zzup());
            } else if (zzuj != 40) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                this.zzavi = Boolean.valueOf(zzxzVar.zzup());
            }
        }
    }
}
