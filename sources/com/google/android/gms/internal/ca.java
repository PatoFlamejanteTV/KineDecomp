package com.google.android.gms.internal;

import android.os.RemoteException;

/* loaded from: classes.dex */
class ca implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzez f1467a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(zzez zzezVar) {
        this.f1467a = zzezVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzeo zzeoVar;
        try {
            zzeoVar = this.f1467a.zzzL;
            zzeoVar.onAdLeftApplication();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLeftApplication.", e);
        }
    }
}
