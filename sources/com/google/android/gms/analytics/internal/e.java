package com.google.android.gms.analytics.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f703a;
    final /* synthetic */ zzb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(zzb zzbVar, boolean z) {
        this.b = zzbVar;
        this.f703a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        oVar = this.b.f737a;
        oVar.a(this.f703a);
    }
}
