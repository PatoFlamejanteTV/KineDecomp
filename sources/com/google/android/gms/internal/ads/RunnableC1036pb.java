package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.pb */
/* loaded from: classes2.dex */
final class RunnableC1036pb implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzamj f12420a;

    public RunnableC1036pb(zzamj zzamjVar) {
        this.f12420a = zzamjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalm zzalmVar;
        try {
            zzalmVar = this.f12420a.zzdnz;
            zzalmVar.onAdOpened();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
