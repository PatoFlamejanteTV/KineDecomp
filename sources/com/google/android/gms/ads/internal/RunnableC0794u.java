package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzabs;
import com.google.android.gms.internal.ads.zzbbd;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.ads.internal.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0794u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzabs f10159a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbb f10160b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0794u(zzbb zzbbVar, zzabs zzabsVar) {
        this.f10160b = zzbbVar;
        this.f10159a = zzabsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f10160b.zzbls.r != null) {
                this.f10160b.zzbls.r.zza(this.f10159a);
                this.f10160b.zzb(this.f10159a.zzsc());
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
