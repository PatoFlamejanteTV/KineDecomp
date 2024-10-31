package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.ia */
/* loaded from: classes2.dex */
public final class RunnableC0938ia implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ InterfaceC0951ja f12205a;

    /* renamed from: b */
    private final /* synthetic */ C0965ka f12206b;

    public RunnableC0938ia(I i, InterfaceC0951ja interfaceC0951ja, C0965ka c0965ka) {
        this.f12205a = interfaceC0951ja;
        this.f12206b = c0965ka;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f12205a.a(this.f12206b);
        } catch (RemoteException e2) {
            zzbbd.zzc("Could not propagate interstitial ad event.", e2);
        }
    }
}
