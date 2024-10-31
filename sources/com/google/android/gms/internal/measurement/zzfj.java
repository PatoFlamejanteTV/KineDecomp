package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfj extends zzyc<zzfj> {
    private static volatile zzfj[] zzavj;
    public Integer zzavk = null;
    public String zzavl = null;
    public zzfk[] zzavm = zzfk.zzmt();
    private Boolean zzavn = null;
    public zzfl zzavo = null;
    public Boolean zzavh = null;
    public Boolean zzavi = null;

    public zzfj() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzfj[] zzms() {
        if (zzavj == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavj == null) {
                    zzavj = new zzfj[0];
                }
            }
        }
        return zzavj;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfj)) {
            return false;
        }
        zzfj zzfjVar = (zzfj) obj;
        Integer num = this.zzavk;
        if (num == null) {
            if (zzfjVar.zzavk != null) {
                return false;
            }
        } else if (!num.equals(zzfjVar.zzavk)) {
            return false;
        }
        String str = this.zzavl;
        if (str == null) {
            if (zzfjVar.zzavl != null) {
                return false;
            }
        } else if (!str.equals(zzfjVar.zzavl)) {
            return false;
        }
        if (!zzyg.equals(this.zzavm, zzfjVar.zzavm)) {
            return false;
        }
        Boolean bool = this.zzavn;
        if (bool == null) {
            if (zzfjVar.zzavn != null) {
                return false;
            }
        } else if (!bool.equals(zzfjVar.zzavn)) {
            return false;
        }
        zzfl zzflVar = this.zzavo;
        if (zzflVar == null) {
            if (zzfjVar.zzavo != null) {
                return false;
            }
        } else if (!zzflVar.equals(zzfjVar.zzavo)) {
            return false;
        }
        Boolean bool2 = this.zzavh;
        if (bool2 == null) {
            if (zzfjVar.zzavh != null) {
                return false;
            }
        } else if (!bool2.equals(zzfjVar.zzavh)) {
            return false;
        }
        Boolean bool3 = this.zzavi;
        if (bool3 == null) {
            if (zzfjVar.zzavi != null) {
                return false;
            }
        } else if (!bool3.equals(zzfjVar.zzavi)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfjVar.zzcet);
        }
        zzye zzyeVar2 = zzfjVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfj.class.getName().hashCode() + 527) * 31;
        Integer num = this.zzavk;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.zzavl;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + zzyg.hashCode(this.zzavm)) * 31;
        Boolean bool = this.zzavn;
        int hashCode4 = hashCode3 + (bool == null ? 0 : bool.hashCode());
        zzfl zzflVar = this.zzavo;
        int hashCode5 = ((hashCode4 * 31) + (zzflVar == null ? 0 : zzflVar.hashCode())) * 31;
        Boolean bool2 = this.zzavh;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.zzavi;
        int hashCode7 = (hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode7 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        Integer num = this.zzavk;
        if (num != null) {
            zzyaVar.zzd(1, num.intValue());
        }
        String str = this.zzavl;
        if (str != null) {
            zzyaVar.zzb(2, str);
        }
        zzfk[] zzfkVarArr = this.zzavm;
        if (zzfkVarArr != null && zzfkVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzfk[] zzfkVarArr2 = this.zzavm;
                if (i >= zzfkVarArr2.length) {
                    break;
                }
                zzfk zzfkVar = zzfkVarArr2[i];
                if (zzfkVar != null) {
                    zzyaVar.zza(3, zzfkVar);
                }
                i++;
            }
        }
        Boolean bool = this.zzavn;
        if (bool != null) {
            zzyaVar.zzb(4, bool.booleanValue());
        }
        zzfl zzflVar = this.zzavo;
        if (zzflVar != null) {
            zzyaVar.zza(5, zzflVar);
        }
        Boolean bool2 = this.zzavh;
        if (bool2 != null) {
            zzyaVar.zzb(6, bool2.booleanValue());
        }
        Boolean bool3 = this.zzavi;
        if (bool3 != null) {
            zzyaVar.zzb(7, bool3.booleanValue());
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
        String str = this.zzavl;
        if (str != null) {
            zzf += zzya.zzc(2, str);
        }
        zzfk[] zzfkVarArr = this.zzavm;
        if (zzfkVarArr != null && zzfkVarArr.length > 0) {
            int i = 0;
            while (true) {
                zzfk[] zzfkVarArr2 = this.zzavm;
                if (i >= zzfkVarArr2.length) {
                    break;
                }
                zzfk zzfkVar = zzfkVarArr2[i];
                if (zzfkVar != null) {
                    zzf += zzya.zzb(3, zzfkVar);
                }
                i++;
            }
        }
        Boolean bool = this.zzavn;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(4) + 1;
        }
        zzfl zzflVar = this.zzavo;
        if (zzflVar != null) {
            zzf += zzya.zzb(5, zzflVar);
        }
        Boolean bool2 = this.zzavh;
        if (bool2 != null) {
            bool2.booleanValue();
            zzf += zzya.zzbd(6) + 1;
        }
        Boolean bool3 = this.zzavi;
        if (bool3 == null) {
            return zzf;
        }
        bool3.booleanValue();
        return zzf + zzya.zzbd(7) + 1;
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
                this.zzavl = zzxzVar.readString();
            } else if (zzuj == 26) {
                int zzb = zzyl.zzb(zzxzVar, 26);
                zzfk[] zzfkVarArr = this.zzavm;
                int length = zzfkVarArr == null ? 0 : zzfkVarArr.length;
                zzfk[] zzfkVarArr2 = new zzfk[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzavm, 0, zzfkVarArr2, 0, length);
                }
                while (length < zzfkVarArr2.length - 1) {
                    zzfkVarArr2[length] = new zzfk();
                    zzxzVar.zza(zzfkVarArr2[length]);
                    zzxzVar.zzuj();
                    length++;
                }
                zzfkVarArr2[length] = new zzfk();
                zzxzVar.zza(zzfkVarArr2[length]);
                this.zzavm = zzfkVarArr2;
            } else if (zzuj == 32) {
                this.zzavn = Boolean.valueOf(zzxzVar.zzup());
            } else if (zzuj == 42) {
                if (this.zzavo == null) {
                    this.zzavo = new zzfl();
                }
                zzxzVar.zza(this.zzavo);
            } else if (zzuj == 48) {
                this.zzavh = Boolean.valueOf(zzxzVar.zzup());
            } else if (zzuj != 56) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                this.zzavi = Boolean.valueOf(zzxzVar.zzup());
            }
        }
    }
}
