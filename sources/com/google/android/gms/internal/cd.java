package com.google.android.gms.internal;

import android.os.RemoteException;

/* loaded from: classes.dex */
class cd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzez f1470a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(zzez zzezVar) {
        this.f1470a = zzezVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzeo zzeoVar;
        try {
            zzeoVar = this.f1470a.zzzL;
            zzeoVar.onAdClosed();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdClosed.", e);
        }
    }
}
