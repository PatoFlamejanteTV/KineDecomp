package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfi extends zzyc<zzfi> {
    private static volatile zzfi[] zzavd;
    public Integer zzave = null;
    public zzfm[] zzavf = zzfm.zzmu();
    public zzfj[] zzavg = zzfj.zzms();
    private Boolean zzavh = null;
    private Boolean zzavi = null;

    public zzfi() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzfi[] zzmr() {
        if (zzavd == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavd == null) {
                    zzavd = new zzfi[0];
                }
            }
        }
        return zzavd;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfi)) {
            return false;
        }
        zzfi zzfiVar = (zzfi) obj;
        Integer num = this.zzave;
        if (num == null) {
            if (zzfiVar.zzave != null) {
                return false;
            }
        } else if (!num.equals(zzfiVar.zzave)) {
            return false;
        }
        if (!zzyg.equals(this.zzavf, zzfiVar.zzavf) || !zzyg.equals(this.zzavg, zzfiVar.zzavg)) {
            return false;
        }
        Boolean bool = this.zzavh;
        if (bool == null) {
            if (zzfiVar.zzavh != null) {
                return false;
            }
        } else if (!bool.equals(zzfiVar.zzavh)) {
            return false;
        }
        Boolean bool2 = this.zzavi;
        if (bool2 == null) {
            if (zzfiVar.zzavi != null) {
                return false;
            }
        } else if (!bool2.equals(zzfiVar.zzavi)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfiVar.zzcet);
        }
        zzye zzyeVar2 = zzfiVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfi.class.getName().hashCode() + 527) * 31;
        Integer num = this.zzave;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zzyg.hashCode(this.zzavf)) * 31) + zzyg.hashCode(this.zzavg)) * 31;
        Boolean bool = this.zzavh;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzavi;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        Integer num = this.zzave;
        if (num != null) {
            zzyaVar.zzd(1, num.intValue());
        }
        zzfm[] zzfmVarArr = this.zzavf;
        int i = 0;
        if (zzfmVarArr != null && zzfmVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzfm[] zzfmVarArr2 = this.zzavf;
                if (i2 >= zzfmVarArr2.length) {
                    break;
                }
                zzfm zzfmVar = zzfmVarArr2[i2];
                if (zzfmVar != null) {
                    zzyaVar.zza(2, zzfmVar);
                }
                i2++;
            }
        }
        zzfj[] zzfjVarArr = this.zzavg;
        if (zzfjVarArr != null && zzfjVarArr.length > 0) {
            while (true) {
                zzfj[] zzfjVarArr2 = this.zzavg;
                if (i >= zzfjVarArr2.length) {
                    break;
                }
                zzfj zzfjVar = zzfjVarArr2[i];
                if (zzfjVar != null) {
                    zzyaVar.zza(3, zzfjVar);
                }
                i++;
            }
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
        Integer num = this.zzave;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        zzfm[] zzfmVarArr = this.zzavf;
        int i = 0;
        if (zzfmVarArr != null && zzfmVarArr.length > 0) {
            int i2 = zzf;
            int i3 = 0;
            while (true) {
                zzfm[] zzfmVarArr2 = this.zzavf;
                if (i3 >= zzfmVarArr2.length) {
                    break;
                }
                zzfm zzfmVar = zzfmVarArr2[i3];
                if (zzfmVar != null) {
                    i2 += zzya.zzb(2, zzfmVar);
                }
                i3++;
            }
            zzf = i2;
        }
        zzfj[] zzfjVarArr = this.zzavg;
        if (zzfjVarArr != null && zzfjVarArr.length > 0) {
            while (true) {
                zzfj[] zzfjVarArr2 = this.zzavg;
                if (i >= zzfjVarArr2.length) {
                    break;
                }
                zzfj zzfjVar = zzfjVarArr2[i];
                if (zzfjVar != null) {
                    zzf += zzya.zzb(3, zzfjVar);
                }
                i++;
            }
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
                this.zzave = Integer.valueOf(zzxzVar.zzvb());
            } else if (zzuj == 18) {
                int zzb = zzyl.zzb(zzxzVar, 18);
                zzfm[] zzfmVarArr = this.zzavf;
                int length = zzfmVarArr == null ? 0 : zzfmVarArr.length;
                zzfm[] zzfmVarArr2 = new zzfm[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzavf, 0, zzfmVarArr2, 0, length);
                }
                while (length < zzfmVarArr2.length - 1) {
                    zzfmVarArr2[length] = new zzfm();
                    zzxzVar.zza(zzfmVarArr2[length]);
                    zzxzVar.zzuj();
                    length++;
                }
                zzfmVarArr2[length] = new zzfm();
                zzxzVar.zza(zzfmVarArr2[length]);
                this.zzavf = zzfmVarArr2;
            } else if (zzuj == 26) {
                int zzb2 = zzyl.zzb(zzxzVar, 26);
                zzfj[] zzfjVarArr = this.zzavg;
                int length2 = zzfjVarArr == null ? 0 : zzfjVarArr.length;
                zzfj[] zzfjVarArr2 = new zzfj[zzb2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.zzavg, 0, zzfjVarArr2, 0, length2);
                }
                while (length2 < zzfjVarArr2.length - 1) {
                    zzfjVarArr2[length2] = new zzfj();
                    zzxzVar.zza(zzfjVarArr2[length2]);
                    zzxzVar.zzuj();
                    length2++;
                }
                zzfjVarArr2[length2] = new zzfj();
                zzxzVar.zza(zzfjVarArr2[length2]);
                this.zzavg = zzfjVarArr2;
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
