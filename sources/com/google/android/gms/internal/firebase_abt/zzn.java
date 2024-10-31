package com.google.android.gms.internal.firebase_abt;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzn extends zzd<zzn> {
    private static volatile zzn[] zzap;
    public String zzaq = "";

    public zzn() {
        this.zzs = null;
        this.zzab = -1;
    }

    public static zzn[] zzo() {
        if (zzap == null) {
            synchronized (zzh.zzaa) {
                if (zzap == null) {
                    zzap = new zzn[0];
                }
            }
        }
        return zzap;
    }

    @Override // com.google.android.gms.internal.firebase_abt.zzj
    public final /* synthetic */ zzj zza(zza zzaVar) throws IOException {
        while (true) {
            int zzd = zzaVar.zzd();
            if (zzd == 0) {
                return this;
            }
            if (zzd == 10) {
                this.zzaq = zzaVar.readString();
            } else if (!super.zza(zzaVar, zzd)) {
                return this;
            }
        }
    }
}
