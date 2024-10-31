package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class An implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzzl f11392a;

    public An(zzzl zzzlVar) {
        this.f11392a = zzzlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzxa zzxaVar;
        zzxa zzxaVar2;
        zzxaVar = this.f11392a.zzbnn;
        if (zzxaVar != null) {
            try {
                zzxaVar2 = this.f11392a.zzbnn;
                zzxaVar2.onAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbbd.zzc("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
