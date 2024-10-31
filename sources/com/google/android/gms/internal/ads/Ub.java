package com.google.android.gms.internal.ads;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
final class Ub implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ CountDownLatch f11869a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzapr f11870b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ub(zzapr zzaprVar, CountDownLatch countDownLatch) {
        this.f11870b = zzaprVar;
        this.f11869a = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgg zzbggVar;
        synchronized (this.f11870b.zzdsn) {
            zzapr zzaprVar = this.f11870b;
            zzbggVar = this.f11870b.zzdin;
            zzaprVar.zzdsy = com.google.android.gms.ads.internal.zzas.a(zzbggVar, this.f11870b.zzdsx, this.f11869a);
        }
    }
}
