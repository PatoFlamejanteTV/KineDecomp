package com.google.android.gms.internal;

import android.os.RemoteException;

/* loaded from: classes.dex */
class bx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzez f1464a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(zzez zzezVar) {
        this.f1464a = zzezVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzeo zzeoVar;
        try {
            zzeoVar = this.f1464a.zzzL;
            zzeoVar.onAdLoaded();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdLoaded.", e);
        }
    }
}
