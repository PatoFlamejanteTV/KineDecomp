package com.google.android.gms.analytics.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f704a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ zzb c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(zzb zzbVar, String str, Runnable runnable) {
        this.c = zzbVar;
        this.f704a = str;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        oVar = this.c.f737a;
        oVar.a(this.f704a);
        if (this.b != null) {
            this.b.run();
        }
    }
}
