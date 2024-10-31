package com.google.android.gms.internal;

import android.os.RemoteException;

/* loaded from: classes.dex */
class bs implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzei f1459a;
    final /* synthetic */ zzek b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(zzek zzekVar, zzei zzeiVar) {
        this.b = zzekVar;
        this.f1459a = zzeiVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1459a.zzzv.destroy();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not destroy mediation adapter.", e);
        }
    }
}
