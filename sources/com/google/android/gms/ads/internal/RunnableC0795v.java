package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzabz;
import com.google.android.gms.internal.ads.zzbbd;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.ads.internal.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0795v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzabz f10161a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbb f10162b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0795v(zzbb zzbbVar, zzabz zzabzVar) {
        this.f10162b = zzbbVar;
        this.f10161a = zzabzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f10162b.zzbls.t != null) {
                this.f10162b.zzbls.t.zza(this.f10161a);
                this.f10162b.zzb(this.f10161a.zzsc());
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
