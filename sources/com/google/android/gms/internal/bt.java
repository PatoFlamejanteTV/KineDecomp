package com.google.android.gms.internal;

import android.os.RemoteException;

/* loaded from: classes.dex */
class bt implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzez f1460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(zzez zzezVar) {
        this.f1460a = zzezVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzeo zzeoVar;
        try {
            zzeoVar = this.f1460a.zzzL;
            zzeoVar.onAdClicked();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdClicked.", e);
        }
    }
}
