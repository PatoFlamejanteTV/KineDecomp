package com.google.android.gms.ads.internal.overlay;

/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzc f590a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zzc zzcVar) {
        this.f590a = zzcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzh zzhVar;
        zzh zzhVar2;
        zzhVar = this.f590a.p;
        if (zzhVar != null) {
            zzhVar2 = this.f590a.p;
            zzhVar2.b();
        }
    }
}
