package com.google.android.gms.internal;

import android.os.RemoteException;

/* loaded from: classes.dex */
class bv implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzez f1462a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(zzez zzezVar) {
        this.f1462a = zzezVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzeo zzeoVar;
        try {
            zzeoVar = this.f1462a.zzzL;
            zzeoVar.onAdLeftApplication();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLeftApplication.", e);
        }
    }
}
