package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzdz;

/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzm f633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(zzm zzmVar) {
        this.f633a = zzmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzdz.zzd zzdVar;
        zzdz.zzd zzdVar2;
        zzdVar = this.f633a.l;
        if (zzdVar != null) {
            zzdVar2 = this.f633a.l;
            zzdVar2.release();
            this.f633a.l = null;
        }
    }
}
