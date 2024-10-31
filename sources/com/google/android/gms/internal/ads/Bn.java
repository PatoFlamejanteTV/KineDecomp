package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class Bn implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzzq f11431a;

    public Bn(zzzq zzzqVar) {
        this.f11431a = zzzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzavb zzavbVar;
        zzavb zzavbVar2;
        zzavbVar = this.f11431a.zzcnc;
        if (zzavbVar != null) {
            try {
                zzavbVar2 = this.f11431a.zzcnc;
                zzavbVar2.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbbd.zzc("Could not notify onRewardedVideoAdFailedToLoad event.", e2);
            }
        }
    }
}
