package com.google.android.gms.analytics.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzw f706a;
    final /* synthetic */ zzb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(zzb zzbVar, zzw zzwVar) {
        this.b = zzbVar;
        this.f706a = zzwVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        oVar = this.b.f737a;
        oVar.a(this.f706a);
    }
}
