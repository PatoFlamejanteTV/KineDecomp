package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class Ha implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ long f13642a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzfd f13643b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha(zzfd zzfdVar, long j) {
        this.f13643b = zzfdVar;
        this.f13642a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13643b.c(this.f13642a);
    }
}
