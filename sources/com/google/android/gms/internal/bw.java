package com.google.android.gms.internal;

import android.os.RemoteException;

/* loaded from: classes.dex */
class bw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzez f1463a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(zzez zzezVar) {
        this.f1463a = zzezVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzeo zzeoVar;
        try {
            zzeoVar = this.f1463a.zzzL;
            zzeoVar.onAdOpened();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdOpened.", e);
        }
    }
}
