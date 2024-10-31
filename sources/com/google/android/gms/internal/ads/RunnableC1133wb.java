package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.wb */
/* loaded from: classes2.dex */
final class RunnableC1133wb implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzamj f12621a;

    public RunnableC1133wb(zzamj zzamjVar) {
        this.f12621a = zzamjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalm zzalmVar;
        try {
            zzalmVar = this.f12621a.zzdnz;
            zzalmVar.onAdClosed();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
