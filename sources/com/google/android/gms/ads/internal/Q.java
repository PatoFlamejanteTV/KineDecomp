package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzabz;
import com.google.android.gms.internal.ads.zzbbd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzabz f10010a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzp f10011b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(zzp zzpVar, zzabz zzabzVar) {
        this.f10011b = zzpVar;
        this.f10010a = zzabzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f10011b.zzbls.t != null) {
                this.f10011b.zzbls.t.zza(this.f10010a);
                this.f10011b.zzb(this.f10010a.zzsc());
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
