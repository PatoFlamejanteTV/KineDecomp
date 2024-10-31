package com.google.android.gms.ads.internal.overlay;

/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzc f593a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(zzc zzcVar) {
        this.f593a = zzcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzh zzhVar;
        zzh zzhVar2;
        zzhVar = this.f593a.p;
        if (zzhVar != null) {
            zzhVar2 = this.f593a.p;
            zzhVar2.a();
        }
    }
}
