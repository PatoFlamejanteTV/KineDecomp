package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfl extends zzyc<zzfl> {
    public Integer zzavu = null;
    public Boolean zzavv = null;
    public String zzavw = null;
    public String zzavx = null;
    public String zzavy = null;

    public zzfl() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    private final zzfl zzc(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                int position = zzxzVar.getPosition();
                try {
                    int zzvb = zzxzVar.zzvb();
                    if (zzvb >= 0 && zzvb <= 4) {
                        this.zzavu = Integer.valueOf(zzvb);
                    } else {
                        StringBuilder sb = new StringBuilder(46);
                        sb.append(zzvb);
                        sb.append(" is not a valid enum ComparisonType");
                        throw new IllegalArgumentException(sb.toString());
                        break;
                    }
                } catch (IllegalArgumentException unused) {
                    zzxzVar.zzcb(position);
                    zza(zzxzVar, zzuj);
                }
            } else if (zzuj == 16) {
                this.zzavv = Boolean.valueOf(zzxzVar.zzup());
            } else if (zzuj == 26) {
                this.zzavw = zzxzVar.readString();
            } else if (zzuj == 34) {
                this.zzavx = zzxzVar.readString();
            } else if (zzuj != 42) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                this.zzavy = zzxzVar.readString();
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfl)) {
            return false;
        }
        zzfl zzflVar = (zzfl) obj;
        Integer num = this.zzavu;
        if (num == null) {
            if (zzflVar.zzavu != null) {
                return false;
            }
        } else if (!num.equals(zzflVar.zzavu)) {
            return false;
        }
        Boolean bool = this.zzavv;
        if (bool == null) {
            if (zzflVar.zzavv != null) {
                return false;
            }
        } else if (!bool.equals(zzflVar.zzavv)) {
            return false;
        }
        String str = this.zzavw;
        if (str == null) {
            if (zzflVar.zzavw != null) {
                return false;
            }
        } else if (!str.equals(zzflVar.zzavw)) {
            return false;
        }
        String str2 = this.zzavx;
        if (str2 == null) {
            if (zzflVar.zzavx != null) {
                return false;
            }
        } else if (!str2.equals(zzflVar.zzavx)) {
            return false;
        }
        String str3 = this.zzavy;
        if (str3 == null) {
            if (zzflVar.zzavy != null) {
                return false;
            }
        } else if (!str3.equals(zzflVar.zzavy)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzflVar.zzcet);
        }
        zzye zzyeVar2 = zzflVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfl.class.getName().hashCode() + 527) * 31;
        Integer num = this.zzavu;
        int i = 0;
        int intValue = (hashCode + (num == null ? 0 : num.intValue())) * 31;
        Boolean bool = this.zzavv;
        int hashCode2 = (intValue + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.zzavw;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzavx;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zzavy;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        Integer num = this.zzavu;
        if (num != null) {
            zzyaVar.zzd(1, num.intValue());
        }
        Boolean bool = this.zzavv;
        if (bool != null) {
            zzyaVar.zzb(2, bool.booleanValue());
        }
        String str = this.zzavw;
        if (str != null) {
            zzyaVar.zzb(3, str);
        }
        String str2 = this.zzavx;
        if (str2 != null) {
            zzyaVar.zzb(4, str2);
        }
        String str3 = this.zzavy;
        if (str3 != null) {
            zzyaVar.zzb(5, str3);
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzavu;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        Boolean bool = this.zzavv;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(2) + 1;
        }
        String str = this.zzavw;
        if (str != null) {
            zzf += zzya.zzc(3, str);
        }
        String str2 = this.zzavx;
        if (str2 != null) {
            zzf += zzya.zzc(4, str2);
        }
        String str3 = this.zzavy;
        return str3 != null ? zzf + zzya.zzc(5, str3) : zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        zzc(zzxzVar);
        return this;
    }
}
