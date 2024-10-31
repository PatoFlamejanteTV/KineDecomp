package com.google.android.gms.analytics.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzab f705a;
    final /* synthetic */ zzb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zzb zzbVar, zzab zzabVar) {
        this.b = zzbVar;
        this.f705a = zzabVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        oVar = this.b.f737a;
        oVar.a(this.f705a);
    }
}
