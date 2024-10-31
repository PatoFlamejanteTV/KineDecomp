package com.google.android.gms.internal;

import android.os.RemoteException;

/* loaded from: classes.dex */
class cb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzez f1468a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(zzez zzezVar) {
        this.f1468a = zzezVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzeo zzeoVar;
        try {
            zzeoVar = this.f1468a.zzzL;
            zzeoVar.onAdOpened();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdOpened.", e);
        }
    }
}
