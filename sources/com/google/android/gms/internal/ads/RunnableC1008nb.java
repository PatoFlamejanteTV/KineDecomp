package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.nb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1008nb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzakx f12343a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1008nb(zzald zzaldVar, zzakx zzakxVar) {
        this.f12343a = zzakxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f12343a.zzdnc.destroy();
        } catch (RemoteException e2) {
            zzbbd.zzc("Could not destroy mediation adapter.", e2);
        }
    }
}
