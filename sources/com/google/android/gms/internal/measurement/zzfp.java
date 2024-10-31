package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfp extends zzyc<zzfp> {
    public Long zzawk = null;
    public String zzafi = null;
    private Integer zzawl = null;
    public zzfq[] zzawm = zzfq.zzmw();
    public zzfo[] zzawn = zzfo.zzmv();
    public zzfi[] zzawo = zzfi.zzmr();
    private String zzawp = null;
    private Boolean zzawq = null;

    public zzfp() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfp)) {
            return false;
        }
        zzfp zzfpVar = (zzfp) obj;
        Long l = this.zzawk;
        if (l == null) {
            if (zzfpVar.zzawk != null) {
                return false;
            }
        } else if (!l.equals(zzfpVar.zzawk)) {
            return false;
        }
        String str = this.zzafi;
        if (str == null) {
            if (zzfpVar.zzafi != null) {
                return false;
            }
        } else if (!str.equals(zzfpVar.zzafi)) {
            return false;
        }
        Integer num = this.zzawl;
        if (num == null) {
            if (zzfpVar.zzawl != null) {
                return false;
            }
        } else if (!num.equals(zzfpVar.zzawl)) {
            return false;
        }
        if (!zzyg.equals(this.zzawm, zzfpVar.zzawm) || !zzyg.equals(this.zzawn, zzfpVar.zzawn) || !zzyg.equals(this.zzawo, zzfpVar.zzawo)) {
            return false;
        }
        String str2 = this.zzawp;
        if (str2 == null) {
            if (zzfpVar.zzawp != null) {
                return false;
            }
        } else if (!str2.equals(zzfpVar.zzawp)) {
            return false;
        }
        Boolean bool = this.zzawq;
        if (bool == null) {
            if (zzfpVar.zzawq != null) {
                return false;
            }
        } else if (!bool.equals(zzfpVar.zzawq)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfpVar.zzcet);
        }
        zzye zzyeVar2 = zzfpVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfp.class.getName().hashCode() + 527) * 31;
        Long l = this.zzawk;
        int i = 0;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.zzafi;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.zzawl;
        int hashCode4 = (((((((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + zzyg.hashCode(this.zzawm)) * 31) + zzyg.hashCode(this.zzawn)) * 31) + zzyg.hashCode(this.zzawo)) * 31;
        String str2 = this.zzawp;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.zzawq;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode6 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        Long l = this.zzawk;
        if (l != null) {
            zzyaVar.zzi(1, l.longValue());
        }
        String str = this.zzafi;
        if (str != null) {
            zzyaVar.zzb(2, str);
        }
        Integer num = this.zzawl;
        if (num != null) {
            zzyaVar.zzd(3, num.intValue());
        }
        zzfq[] zzfqVarArr = this.zzawm;
        int i = 0;
        if (zzfqVarArr != null && zzfqVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzfq[] zzfqVarArr2 = this.zzawm;
                if (i2 >= zzfqVarArr2.length) {
                    break;
                }
                zzfq zzfqVar = zzfqVarArr2[i2];
                if (zzfqVar != null) {
                    zzyaVar.zza(4, zzfqVar);
                }
                i2++;
            }
        }
        zzfo[] zzfoVarArr = this.zzawn;
        if (zzfoVarArr != null && zzfoVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzfo[] zzfoVarArr2 = this.zzawn;
                if (i3 >= zzfoVarArr2.length) {
                    break;
                }
                zzfo zzfoVar = zzfoVarArr2[i3];
                if (zzfoVar != null) {
                    zzyaVar.zza(5, zzfoVar);
                }
                i3++;
            }
        }
        zzfi[] zzfiVarArr = this.zzawo;
        if (zzfiVarArr != null && zzfiVarArr.length > 0) {
            while (true) {
                zzfi[] zzfiVarArr2 = this.zzawo;
                if (i >= zzfiVarArr2.length) {
                    break;
                }
                zzfi zzfiVar = zzfiVarArr2[i];
                if (zzfiVar != null) {
                    zzyaVar.zza(6, zzfiVar);
                }
                i++;
            }
        }
        String str2 = this.zzawp;
        if (str2 != null) {
            zzyaVar.zzb(7, str2);
        }
        Boolean bool = this.zzawq;
        if (bool != null) {
            zzyaVar.zzb(8, bool.booleanValue());
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int zzf = super.zzf();
        Long l = this.zzawk;
        if (l != null) {
            zzf += zzya.zzd(1, l.longValue());
        }
        String str = this.zzafi;
        if (str != null) {
            zzf += zzya.zzc(2, str);
        }
        Integer num = this.zzawl;
        if (num != null) {
            zzf += zzya.zzh(3, num.intValue());
        }
        zzfq[] zzfqVarArr = this.zzawm;
        int i = 0;
        if (zzfqVarArr != null && zzfqVarArr.length > 0) {
            int i2 = zzf;
            int i3 = 0;
            while (true) {
                zzfq[] zzfqVarArr2 = this.zzawm;
                if (i3 >= zzfqVarArr2.length) {
                    break;
                }
                zzfq zzfqVar = zzfqVarArr2[i3];
                if (zzfqVar != null) {
                    i2 += zzya.zzb(4, zzfqVar);
                }
                i3++;
            }
            zzf = i2;
        }
        zzfo[] zzfoVarArr = this.zzawn;
        if (zzfoVarArr != null && zzfoVarArr.length > 0) {
            int i4 = zzf;
            int i5 = 0;
            while (true) {
                zzfo[] zzfoVarArr2 = this.zzawn;
                if (i5 >= zzfoVarArr2.length) {
                    break;
                }
                zzfo zzfoVar = zzfoVarArr2[i5];
                if (zzfoVar != null) {
                    i4 += zzya.zzb(5, zzfoVar);
                }
                i5++;
            }
            zzf = i4;
        }
        zzfi[] zzfiVarArr = this.zzawo;
        if (zzfiVarArr != null && zzfiVarArr.length > 0) {
            while (true) {
                zzfi[] zzfiVarArr2 = this.zzawo;
                if (i >= zzfiVarArr2.length) {
                    break;
                }
                zzfi zzfiVar = zzfiVarArr2[i];
                if (zzfiVar != null) {
                    zzf += zzya.zzb(6, zzfiVar);
                }
                i++;
            }
        }
        String str2 = this.zzawp;
        if (str2 != null) {
            zzf += zzya.zzc(7, str2);
        }
        Boolean bool = this.zzawq;
        if (bool == null) {
            return zzf;
        }
        bool.booleanValue();
        return zzf + zzya.zzbd(8) + 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzawk = Long.valueOf(zzxzVar.zzvc());
            } else if (zzuj == 18) {
                this.zzafi = zzxzVar.readString();
            } else if (zzuj == 24) {
                this.zzawl = Integer.valueOf(zzxzVar.zzvb());
            } else if (zzuj == 34) {
                int zzb = zzyl.zzb(zzxzVar, 34);
                zzfq[] zzfqVarArr = this.zzawm;
                int length = zzfqVarArr == null ? 0 : zzfqVarArr.length;
                zzfq[] zzfqVarArr2 = new zzfq[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzawm, 0, zzfqVarArr2, 0, length);
                }
                while (length < zzfqVarArr2.length - 1) {
                    zzfqVarArr2[length] = new zzfq();
                    zzxzVar.zza(zzfqVarArr2[length]);
                    zzxzVar.zzuj();
                    length++;
                }
                zzfqVarArr2[length] = new zzfq();
                zzxzVar.zza(zzfqVarArr2[length]);
                this.zzawm = zzfqVarArr2;
            } else if (zzuj == 42) {
                int zzb2 = zzyl.zzb(zzxzVar, 42);
                zzfo[] zzfoVarArr = this.zzawn;
                int length2 = zzfoVarArr == null ? 0 : zzfoVarArr.length;
                zzfo[] zzfoVarArr2 = new zzfo[zzb2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.zzawn, 0, zzfoVarArr2, 0, length2);
                }
                while (length2 < zzfoVarArr2.length - 1) {
                    zzfoVarArr2[length2] = new zzfo();
                    zzxzVar.zza(zzfoVarArr2[length2]);
                    zzxzVar.zzuj();
                    length2++;
                }
                zzfoVarArr2[length2] = new zzfo();
                zzxzVar.zza(zzfoVarArr2[length2]);
                this.zzawn = zzfoVarArr2;
            } else if (zzuj == 50) {
                int zzb3 = zzyl.zzb(zzxzVar, 50);
                zzfi[] zzfiVarArr = this.zzawo;
                int length3 = zzfiVarArr == null ? 0 : zzfiVarArr.length;
                zzfi[] zzfiVarArr2 = new zzfi[zzb3 + length3];
                if (length3 != 0) {
                    System.arraycopy(this.zzawo, 0, zzfiVarArr2, 0, length3);
                }
                while (length3 < zzfiVarArr2.length - 1) {
                    zzfiVarArr2[length3] = new zzfi();
                    zzxzVar.zza(zzfiVarArr2[length3]);
                    zzxzVar.zzuj();
                    length3++;
                }
                zzfiVarArr2[length3] = new zzfi();
                zzxzVar.zza(zzfiVarArr2[length3]);
                this.zzawo = zzfiVarArr2;
            } else if (zzuj == 58) {
                this.zzawp = zzxzVar.readString();
            } else if (zzuj != 64) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                this.zzawq = Boolean.valueOf(zzxzVar.zzup());
            }
        }
    }
}
