package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.vb */
/* loaded from: classes2.dex */
final class RunnableC1119vb implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzamj f12600a;

    public RunnableC1119vb(zzamj zzamjVar) {
        this.f12600a = zzamjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalm zzalmVar;
        try {
            zzalmVar = this.f12600a.zzdnz;
            zzalmVar.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
