package com.google.android.gms.internal;

import android.os.RemoteException;

/* loaded from: classes.dex */
class cc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzez f1469a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(zzez zzezVar) {
        this.f1469a = zzezVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzeo zzeoVar;
        try {
            zzeoVar = this.f1469a.zzzL;
            zzeoVar.onAdLoaded();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLoaded.", e);
        }
    }
}
