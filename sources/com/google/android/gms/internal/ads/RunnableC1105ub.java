package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.ub */
/* loaded from: classes2.dex */
final class RunnableC1105ub implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzamj f12576a;

    public RunnableC1105ub(zzamj zzamjVar) {
        this.f12576a = zzamjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalm zzalmVar;
        try {
            zzalmVar = this.f12576a.zzdnz;
            zzalmVar.onAdOpened();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
