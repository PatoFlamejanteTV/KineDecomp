package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfo extends zzyc<zzfo> {
    private static volatile zzfo[] zzawg;
    public String name = null;
    public Boolean zzawh = null;
    public Boolean zzawi = null;
    public Integer zzawj = null;

    public zzfo() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzfo[] zzmv() {
        if (zzawg == null) {
            synchronized (zzyg.zzcfc) {
                if (zzawg == null) {
                    zzawg = new zzfo[0];
                }
            }
        }
        return zzawg;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfo)) {
            return false;
        }
        zzfo zzfoVar = (zzfo) obj;
        String str = this.name;
        if (str == null) {
            if (zzfoVar.name != null) {
                return false;
            }
        } else if (!str.equals(zzfoVar.name)) {
            return false;
        }
        Boolean bool = this.zzawh;
        if (bool == null) {
            if (zzfoVar.zzawh != null) {
                return false;
            }
        } else if (!bool.equals(zzfoVar.zzawh)) {
            return false;
        }
        Boolean bool2 = this.zzawi;
        if (bool2 == null) {
            if (zzfoVar.zzawi != null) {
                return false;
            }
        } else if (!bool2.equals(zzfoVar.zzawi)) {
            return false;
        }
        Integer num = this.zzawj;
        if (num == null) {
            if (zzfoVar.zzawj != null) {
                return false;
            }
        } else if (!num.equals(zzfoVar.zzawj)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfoVar.zzcet);
        }
        zzye zzyeVar2 = zzfoVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfo.class.getName().hashCode() + 527) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.zzawh;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzawi;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.zzawj;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        String str = this.name;
        if (str != null) {
            zzyaVar.zzb(1, str);
        }
        Boolean bool = this.zzawh;
        if (bool != null) {
            zzyaVar.zzb(2, bool.booleanValue());
        }
        Boolean bool2 = this.zzawi;
        if (bool2 != null) {
            zzyaVar.zzb(3, bool2.booleanValue());
        }
        Integer num = this.zzawj;
        if (num != null) {
            zzyaVar.zzd(4, num.intValue());
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
        Boolean bool = this.zzawh;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(2) + 1;
        }
        Boolean bool2 = this.zzawi;
        if (bool2 != null) {
            bool2.booleanValue();
            zzf += zzya.zzbd(3) + 1;
        }
        Integer num = this.zzawj;
        return num != null ? zzf + zzya.zzh(4, num.intValue()) : zzf;
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
            } else if (zzuj == 16) {
                this.zzawh = Boolean.valueOf(zzxzVar.zzup());
            } else if (zzuj == 24) {
                this.zzawi = Boolean.valueOf(zzxzVar.zzup());
            } else if (zzuj != 32) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                this.zzawj = Integer.valueOf(zzxzVar.zzvb());
            }
        }
    }
}
