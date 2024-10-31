package com.google.android.gms.analytics.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzw f719a;
    final /* synthetic */ long b;
    final /* synthetic */ o c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, zzw zzwVar, long j) {
        this.c = oVar;
        this.f719a = zzwVar;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.f719a, this.b);
    }
}
