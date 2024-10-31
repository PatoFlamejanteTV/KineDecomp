package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfs extends zzyc<zzfs> {
    private static volatile zzfs[] zzaww;
    public Integer zzawx = null;
    public Long zzawy = null;

    public zzfs() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzfs[] zzmy() {
        if (zzaww == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaww == null) {
                    zzaww = new zzfs[0];
                }
            }
        }
        return zzaww;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfs)) {
            return false;
        }
        zzfs zzfsVar = (zzfs) obj;
        Integer num = this.zzawx;
        if (num == null) {
            if (zzfsVar.zzawx != null) {
                return false;
            }
        } else if (!num.equals(zzfsVar.zzawx)) {
            return false;
        }
        Long l = this.zzawy;
        if (l == null) {
            if (zzfsVar.zzawy != null) {
                return false;
            }
        } else if (!l.equals(zzfsVar.zzawy)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfsVar.zzcet);
        }
        zzye zzyeVar2 = zzfsVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfs.class.getName().hashCode() + 527) * 31;
        Integer num = this.zzawx;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.zzawy;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        Integer num = this.zzawx;
        if (num != null) {
            zzyaVar.zzd(1, num.intValue());
        }
        Long l = this.zzawy;
        if (l != null) {
            zzyaVar.zzi(2, l.longValue());
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzawx;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        Long l = this.zzawy;
        return l != null ? zzf + zzya.zzd(2, l.longValue()) : zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzawx = Integer.valueOf(zzxzVar.zzvb());
            } else if (zzuj != 16) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                this.zzawy = Long.valueOf(zzxzVar.zzvc());
            }
        }
    }
}
