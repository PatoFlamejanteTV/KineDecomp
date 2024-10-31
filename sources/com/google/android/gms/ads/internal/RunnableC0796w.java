package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzbbd;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.ads.internal.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0796w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzabu f10163a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbb f10164b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0796w(zzbb zzbbVar, zzabu zzabuVar) {
        this.f10164b = zzbbVar;
        this.f10163a = zzabuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f10164b.zzbls.s != null) {
                this.f10164b.zzbls.s.zza(this.f10163a);
                this.f10164b.zzb(this.f10163a.zzsc());
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
