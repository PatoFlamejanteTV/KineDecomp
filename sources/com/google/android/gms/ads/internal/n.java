package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f587a;
    final /* synthetic */ zzo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(zzo zzoVar, WeakReference weakReference) {
        this.b = zzoVar;
        this.f587a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        AdRequestParcel adRequestParcel;
        this.b.d = false;
        zza zzaVar = (zza) this.f587a.get();
        if (zzaVar != null) {
            adRequestParcel = this.b.c;
            zzaVar.zzd(adRequestParcel);
        }
    }
}
