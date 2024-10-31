package com.google.android.gms.ads.internal.overlay;

/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzc f591a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzc zzcVar) {
        this.f591a = zzcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzh zzhVar;
        zzh zzhVar2;
        zzhVar = this.f591a.p;
        if (zzhVar != null) {
            zzhVar2 = this.f591a.p;
            zzhVar2.e();
        }
    }
}
