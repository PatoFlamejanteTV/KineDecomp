package com.google.android.gms.ads.internal.overlay;

/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzc f596a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zzc zzcVar) {
        this.f596a = zzcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzh zzhVar;
        zzh zzhVar2;
        zzhVar = this.f596a.p;
        if (zzhVar != null) {
            zzhVar2 = this.f596a.p;
            zzhVar2.d();
        }
    }
}
