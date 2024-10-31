package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzabs;
import com.google.android.gms.internal.ads.zzbbd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class S implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzabs f10012a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzp f10013b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(zzp zzpVar, zzabs zzabsVar) {
        this.f10013b = zzpVar;
        this.f10012a = zzabsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f10013b.zzbls.r != null) {
                this.f10013b.zzbls.r.zza(this.f10012a);
                this.f10013b.zzb(this.f10012a.zzsc());
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
