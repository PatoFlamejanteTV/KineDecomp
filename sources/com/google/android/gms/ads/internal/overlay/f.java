package com.google.android.gms.ads.internal.overlay;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzc f595a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(zzc zzcVar) {
        this.f595a = zzcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzh zzhVar;
        zzh zzhVar2;
        zzhVar = this.f595a.p;
        if (zzhVar != null) {
            zzhVar2 = this.f595a.p;
            zzhVar2.c();
        }
    }
}
