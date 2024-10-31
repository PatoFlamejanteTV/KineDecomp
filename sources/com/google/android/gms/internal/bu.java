package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;

/* loaded from: classes.dex */
class bu implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdRequest.ErrorCode f1461a;
    final /* synthetic */ zzez b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(zzez zzezVar, AdRequest.ErrorCode errorCode) {
        this.b = zzezVar;
        this.f1461a = errorCode;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzeo zzeoVar;
        try {
            zzeoVar = this.b.zzzL;
            zzeoVar.onAdFailedToLoad(zzfa.zza(this.f1461a));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call onAdFailedToLoad.", e);
        }
    }
}
