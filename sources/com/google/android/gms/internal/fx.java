package com.google.android.gms.internal;

/* loaded from: classes.dex */
class fx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.support.v4.app.l f1568a;
    final /* synthetic */ zzli b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fx(zzli zzliVar, android.support.v4.app.l lVar) {
        this.b = zzliVar;
        this.f1568a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        if (this.f1568a.isFinishing() || this.f1568a.getSupportFragmentManager().d()) {
            return;
        }
        zzlp zzb = zzlp.zzb(this.f1568a);
        i = this.b.zzaaM;
        zzb.zzbp(i);
    }
}
