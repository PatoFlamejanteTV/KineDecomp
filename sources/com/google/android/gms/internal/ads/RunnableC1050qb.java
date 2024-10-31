package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.qb */
/* loaded from: classes2.dex */
final class RunnableC1050qb implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzamj f12447a;

    public RunnableC1050qb(zzamj zzamjVar) {
        this.f12447a = zzamjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalm zzalmVar;
        try {
            zzalmVar = this.f12447a.zzdnz;
            zzalmVar.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
