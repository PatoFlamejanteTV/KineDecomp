package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzbu extends zzan {
    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zzbu(zzap zzapVar) {
        super(zzapVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void zzaw() {
    }

    public final zzv zzfa() {
        zzdb();
        return zzcq().c();
    }

    public final String zzfb() {
        zzdb();
        zzv zzfa = zzfa();
        int i = zzfa.zzul;
        int i2 = zzfa.zzum;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append(FragmentC2201x.f23219a);
        sb.append(i2);
        return sb.toString();
    }
}
