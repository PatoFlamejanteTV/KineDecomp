package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzabw;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzbbd;

/* loaded from: classes.dex */
final class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f10165a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaxf f10166b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzbb f10167c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(zzbb zzbbVar, String str, zzaxf zzaxfVar) {
        this.f10167c = zzbbVar;
        this.f10165a = str;
        this.f10166b = zzaxfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f10167c.zzbls.w.get(this.f10165a).zzb((zzabw) this.f10166b.zzehp);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
