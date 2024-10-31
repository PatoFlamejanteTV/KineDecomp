package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfn extends zzyc<zzfn> {
    public Integer zzawc = null;
    public String zzawd = null;
    public Boolean zzawe = null;
    public String[] zzawf = zzyl.zzcfm;

    public zzfn() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    private final zzfn zzd(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                int position = zzxzVar.getPosition();
                try {
                    int zzvb = zzxzVar.zzvb();
                    if (zzvb >= 0 && zzvb <= 6) {
                        this.zzawc = Integer.valueOf(zzvb);
                    } else {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append(zzvb);
                        sb.append(" is not a valid enum MatchType");
                        throw new IllegalArgumentException(sb.toString());
                        break;
                    }
                } catch (IllegalArgumentException unused) {
                    zzxzVar.zzcb(position);
                    zza(zzxzVar, zzuj);
                }
            } else if (zzuj == 18) {
                this.zzawd = zzxzVar.readString();
            } else if (zzuj == 24) {
                this.zzawe = Boolean.valueOf(zzxzVar.zzup());
            } else if (zzuj != 34) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                int zzb = zzyl.zzb(zzxzVar, 34);
                String[] strArr = this.zzawf;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[zzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzawf, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = zzxzVar.readString();
                    zzxzVar.zzuj();
                    length++;
                }
                strArr2[length] = zzxzVar.readString();
                this.zzawf = strArr2;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfn)) {
            return false;
        }
        zzfn zzfnVar = (zzfn) obj;
        Integer num = this.zzawc;
        if (num == null) {
            if (zzfnVar.zzawc != null) {
                return false;
            }
        } else if (!num.equals(zzfnVar.zzawc)) {
            return false;
        }
        String str = this.zzawd;
        if (str == null) {
            if (zzfnVar.zzawd != null) {
                return false;
            }
        } else if (!str.equals(zzfnVar.zzawd)) {
            return false;
        }
        Boolean bool = this.zzawe;
        if (bool == null) {
            if (zzfnVar.zzawe != null) {
                return false;
            }
        } else if (!bool.equals(zzfnVar.zzawe)) {
            return false;
        }
        if (!zzyg.equals(this.zzawf, zzfnVar.zzawf)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfnVar.zzcet);
        }
        zzye zzyeVar2 = zzfnVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfn.class.getName().hashCode() + 527) * 31;
        Integer num = this.zzawc;
        int i = 0;
        int intValue = (hashCode + (num == null ? 0 : num.intValue())) * 31;
        String str = this.zzawd;
        int hashCode2 = (intValue + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.zzawe;
        int hashCode3 = (((hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + zzyg.hashCode(this.zzawf)) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        Integer num = this.zzawc;
        if (num != null) {
            zzyaVar.zzd(1, num.intValue());
        }
        String str = this.zzawd;
        if (str != null) {
            zzyaVar.zzb(2, str);
        }
        Boolean bool = this.zzawe;
        if (bool != null) {
            zzyaVar.zzb(3, bool.booleanValue());
        }
        String[] strArr = this.zzawf;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.zzawf;
                if (i >= strArr2.length) {
                    break;
                }
                String str2 = strArr2[i];
                if (str2 != null) {
                    zzyaVar.zzb(4, str2);
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
        Integer num = this.zzawc;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        String str = this.zzawd;
        if (str != null) {
            zzf += zzya.zzc(2, str);
        }
        Boolean bool = this.zzawe;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(3) + 1;
        }
        String[] strArr = this.zzawf;
        if (strArr == null || strArr.length <= 0) {
            return zzf;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.zzawf;
            if (i >= strArr2.length) {
                return zzf + i2 + (i3 * 1);
            }
            String str2 = strArr2[i];
            if (str2 != null) {
                i3++;
                i2 += zzya.zzgc(str2);
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        zzd(zzxzVar);
        return this;
    }
}
