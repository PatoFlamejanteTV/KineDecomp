package com.google.android.gms.ads.internal.overlay;

/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzc f594a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(zzc zzcVar) {
        this.f594a = zzcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzh zzhVar;
        zzh zzhVar2;
        zzh zzhVar3;
        zzhVar = this.f594a.p;
        if (zzhVar != null) {
            zzhVar2 = this.f594a.p;
            zzhVar2.d();
            zzhVar3 = this.f594a.p;
            zzhVar3.f();
        }
    }
}
