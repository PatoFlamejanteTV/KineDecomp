package com.google.android.gms.internal;

import org.keyczar.Keyczar;

/* loaded from: classes.dex */
class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1662a;
    final /* synthetic */ zzbd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(zzbd zzbdVar, String str) {
        this.b = zzbdVar;
        this.f1662a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        zziz zzizVar;
        zzizVar = this.b.zzoM;
        zzizVar.loadData(this.f1662a, "text/html", Keyczar.DEFAULT_ENCODING);
    }
}
