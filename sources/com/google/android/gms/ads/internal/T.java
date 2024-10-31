package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzbbd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class T implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzabu f10014a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzp f10015b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(zzp zzpVar, zzabu zzabuVar) {
        this.f10015b = zzpVar;
        this.f10014a = zzabuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f10015b.zzbls.s != null) {
                this.f10015b.zzbls.s.zza(this.f10014a);
                this.f10015b.zzb(this.f10014a.zzsc());
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
