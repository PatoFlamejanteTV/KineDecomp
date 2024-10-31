package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzfw;

@zzgr
/* loaded from: classes.dex */
public final class zzgb extends zzfw.zza {
    private final PlayStorePurchaseListener zztJ;

    public zzgb(PlayStorePurchaseListener playStorePurchaseListener) {
        this.zztJ = playStorePurchaseListener;
    }

    @Override // com.google.android.gms.internal.zzfw
    public boolean isValidPurchase(String str) {
        return this.zztJ.a(str);
    }

    @Override // com.google.android.gms.internal.zzfw
    public void zza(zzfv zzfvVar) {
        this.zztJ.a(new zzfz(zzfvVar));
    }
}
