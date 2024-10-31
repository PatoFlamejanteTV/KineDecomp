package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.yb */
/* loaded from: classes2.dex */
final class RunnableC1161yb implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzamj f12679a;

    public RunnableC1161yb(zzamj zzamjVar) {
        this.f12679a = zzamjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalm zzalmVar;
        try {
            zzalmVar = this.f12679a.zzdnz;
            zzalmVar.onAdLeftApplication();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
