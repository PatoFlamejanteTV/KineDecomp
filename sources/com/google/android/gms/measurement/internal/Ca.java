package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class Ca implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzfo f13619a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Runnable f13620b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ca(zzey zzeyVar, zzfo zzfoVar, Runnable runnable) {
        this.f13619a = zzfoVar;
        this.f13620b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13619a.n();
        this.f13619a.a(this.f13620b);
        this.f13619a.m();
    }
}
