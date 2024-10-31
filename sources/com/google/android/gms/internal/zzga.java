package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;

@zzgr
/* loaded from: classes.dex */
public class zzga implements InAppPurchase {
    private final zzfr zzCM;

    public zzga(zzfr zzfrVar) {
        this.zzCM = zzfrVar;
    }

    public String getProductId() {
        try {
            return this.zzCM.getProductId();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int i) {
        try {
            this.zzCM.recordPlayBillingResolution(i);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int i) {
        try {
            this.zzCM.recordResolution(i);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
