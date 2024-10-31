package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class zn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ yn f12715a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zn(yn ynVar) {
        this.f12715a = ynVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzzh.zza(this.f12715a.f12691a) != null) {
            try {
                zzzh.zza(this.f12715a.f12691a).onAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbbd.zzc("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
