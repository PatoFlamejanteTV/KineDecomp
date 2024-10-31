package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2043a;
    final /* synthetic */ zzp b;

    public r(zzp zzpVar, String str) {
        this.b = zzpVar;
        this.f2043a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzs e = this.b.g.e();
        if (!e.v() || e.w()) {
            this.b.a(6, "Persisted config not initialized . Not logging error/warn.");
        } else {
            e.b.a(this.f2043a);
        }
    }
}
