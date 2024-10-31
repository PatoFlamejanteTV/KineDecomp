package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.ob */
/* loaded from: classes2.dex */
final class RunnableC1022ob implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzamj f12380a;

    public RunnableC1022ob(zzamj zzamjVar) {
        this.f12380a = zzamjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalm zzalmVar;
        try {
            zzalmVar = this.f12380a.zzdnz;
            zzalmVar.onAdClicked();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
