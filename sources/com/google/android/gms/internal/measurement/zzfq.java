package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzfq extends zzyc<zzfq> {
    private static volatile zzfq[] zzawr;
    public String zzoj = null;
    public String value = null;

    public zzfq() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public static zzfq[] zzmw() {
        if (zzawr == null) {
            synchronized (zzyg.zzcfc) {
                if (zzawr == null) {
                    zzawr = new zzfq[0];
                }
            }
        }
        return zzawr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfq)) {
            return false;
        }
        zzfq zzfqVar = (zzfq) obj;
        String str = this.zzoj;
        if (str == null) {
            if (zzfqVar.zzoj != null) {
                return false;
            }
        } else if (!str.equals(zzfqVar.zzoj)) {
            return false;
        }
        String str2 = this.value;
        if (str2 == null) {
            if (zzfqVar.value != null) {
                return false;
            }
        } else if (!str2.equals(zzfqVar.value)) {
            return false;
        }
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            return this.zzcet.equals(zzfqVar.zzcet);
        }
        zzye zzyeVar2 = zzfqVar.zzcet;
        return zzyeVar2 == null || zzyeVar2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (zzfq.class.getName().hashCode() + 527) * 31;
        String str = this.zzoj;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.value;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar != null && !zzyeVar.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final void zza(zzya zzyaVar) throws IOException {
        String str = this.zzoj;
        if (str != null) {
            zzyaVar.zzb(1, str);
        }
        String str2 = this.value;
        if (str2 != null) {
            zzyaVar.zzb(2, str2);
        }
        super.zza(zzyaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyc, com.google.android.gms.internal.measurement.zzyi
    public final int zzf() {
        int zzf = super.zzf();
        String str = this.zzoj;
        if (str != null) {
            zzf += zzya.zzc(1, str);
        }
        String str2 = this.value;
        return str2 != null ? zzf + zzya.zzc(2, str2) : zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxzVar) throws IOException {
        while (true) {
            int zzuj = zzxzVar.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                this.zzoj = zzxzVar.readString();
            } else if (zzuj != 18) {
                if (!super.zza(zzxzVar, zzuj)) {
                    return this;
                }
            } else {
                this.value = zzxzVar.readString();
            }
        }
    }
}
