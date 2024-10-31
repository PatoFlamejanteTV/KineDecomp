package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1426l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f13793a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ C1424k f13794b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1426l(C1424k c1424k, boolean z) {
        this.f13794b = c1424k;
        this.f13793a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar;
        zzfoVar = this.f13794b.f13787a;
        zzfoVar.a(this.f13793a);
    }
}
