package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.tb */
/* loaded from: classes2.dex */
final class RunnableC1091tb implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzamj f12545a;

    public RunnableC1091tb(zzamj zzamjVar) {
        this.f12545a = zzamjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalm zzalmVar;
        try {
            zzalmVar = this.f12545a.zzdnz;
            zzalmVar.onAdLeftApplication();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
