package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@zzgr
/* loaded from: classes.dex */
public class zzfz implements InAppPurchaseResult {
    private final zzfv zzDc;

    public zzfz(zzfv zzfvVar) {
        this.zzDc = zzfvVar;
    }

    public void finishPurchase() {
        try {
            this.zzDc.finishPurchase();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    public String getProductId() {
        try {
            return this.zzDc.getProductId();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    public Intent getPurchaseData() {
        try {
            return this.zzDc.getPurchaseData();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    public int getResultCode() {
        try {
            return this.zzDc.getResultCode();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    public boolean isVerified() {
        try {
            return this.zzDc.isVerified();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
