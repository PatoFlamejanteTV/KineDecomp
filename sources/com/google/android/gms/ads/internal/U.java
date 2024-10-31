package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzbbd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class U implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzadx f10016a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzp f10017b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(zzp zzpVar, zzadx zzadxVar) {
        this.f10017b = zzpVar;
        this.f10016a = zzadxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f10017b.zzbls.w.get(this.f10016a.getCustomTemplateId()).zzb(this.f10016a);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
