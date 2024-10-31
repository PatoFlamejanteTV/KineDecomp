package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class Ga implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ long f13637a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzfd f13638b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ga(zzfd zzfdVar, long j) {
        this.f13638b = zzfdVar;
        this.f13637a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13638b.b(this.f13637a);
    }
}
