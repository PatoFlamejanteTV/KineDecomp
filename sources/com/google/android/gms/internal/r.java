package com.google.android.gms.internal;

import org.keyczar.Keyczar;

/* loaded from: classes.dex */
class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1661a;
    final /* synthetic */ zzbd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(zzbd zzbdVar, String str) {
        this.b = zzbdVar;
        this.f1661a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        zziz zzizVar;
        zzizVar = this.b.zzoM;
        zzizVar.loadData(this.f1661a, "text/html", Keyczar.DEFAULT_ENCODING);
    }
}
