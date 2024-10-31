package com.google.android.gms.internal;

/* loaded from: classes.dex */
class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1660a;
    final /* synthetic */ String b;
    final /* synthetic */ zzbd c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(zzbd zzbdVar, String str, String str2) {
        this.c = zzbdVar;
        this.f1660a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        zziz zzizVar;
        zzizVar = this.c.zzoM;
        zzizVar.zza(this.f1660a, this.b);
    }
}
