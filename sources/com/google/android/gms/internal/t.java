package com.google.android.gms.internal;

/* loaded from: classes.dex */
class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1663a;
    final /* synthetic */ zzbd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(zzbd zzbdVar, String str) {
        this.b = zzbdVar;
        this.f1663a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        zziz zzizVar;
        zzizVar = this.b.zzoM;
        zzizVar.loadUrl(this.f1663a);
    }
}
