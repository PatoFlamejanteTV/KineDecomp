package com.google.android.gms.ads.internal.overlay;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f592a;
    final /* synthetic */ String b;
    final /* synthetic */ zzc c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zzc zzcVar, String str, String str2) {
        this.c = zzcVar;
        this.f592a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzh zzhVar;
        zzh zzhVar2;
        zzhVar = this.c.p;
        if (zzhVar != null) {
            zzhVar2 = this.c.p;
            zzhVar2.a(this.f592a, this.b);
        }
    }
}
