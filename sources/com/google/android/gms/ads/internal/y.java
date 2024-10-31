package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzbbd;

/* loaded from: classes.dex */
final class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzadx f10168a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbb f10169b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(zzbb zzbbVar, zzadx zzadxVar) {
        this.f10169b = zzbbVar;
        this.f10168a = zzadxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f10169b.zzbls.w.get(this.f10168a.getCustomTemplateId()).zzb(this.f10168a);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
