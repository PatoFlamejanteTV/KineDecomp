package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzwb;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ WeakReference f10170a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbl f10171b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(zzbl zzblVar, WeakReference weakReference) {
        this.f10171b = zzblVar;
        this.f10170a = weakReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzwb zzwbVar;
        zzbl.a(this.f10171b, false);
        zza zzaVar = (zza) this.f10170a.get();
        if (zzaVar != null) {
            zzwbVar = this.f10171b.f10228c;
            if (zzaVar.zzc(zzwbVar)) {
                zzaVar.zzb(zzwbVar);
            } else {
                zzbbd.zzen("Ad is not visible. Not refreshing ad.");
                zzaVar.zzblr.b(zzwbVar);
            }
        }
    }
}
