package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzfs;

@zzgr
/* loaded from: classes.dex */
public final class zzfx extends zzfs.zza {
    private final InAppPurchaseListener zztI;

    public zzfx(InAppPurchaseListener inAppPurchaseListener) {
        this.zztI = inAppPurchaseListener;
    }

    @Override // com.google.android.gms.internal.zzfs
    public void zza(zzfr zzfrVar) {
        this.zztI.a(new zzga(zzfrVar));
    }
}
