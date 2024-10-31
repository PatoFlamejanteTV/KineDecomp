package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.rb */
/* loaded from: classes2.dex */
final class RunnableC1063rb implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzamj f12480a;

    public RunnableC1063rb(zzamj zzamjVar) {
        this.f12480a = zzamjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalm zzalmVar;
        try {
            zzalmVar = this.f12480a.zzdnz;
            zzalmVar.onAdClosed();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
