package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzba extends zzan {
    private final zzq zzsu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(zzap zzapVar) {
        super(zzapVar);
        this.zzsu = new zzq();
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void zzaw() {
        zzcq().b().zzb(this.zzsu);
        zzda zzcu = zzcu();
        String zzaz = zzcu.zzaz();
        if (zzaz != null) {
            this.zzsu.setAppName(zzaz);
        }
        String zzba = zzcu.zzba();
        if (zzba != null) {
            this.zzsu.setAppVersion(zzba);
        }
    }

    public final zzq zzdv() {
        zzdb();
        return this.zzsu;
    }
}
