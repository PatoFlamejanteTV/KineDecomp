package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.ca, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1409ca implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f13751a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzda f13752b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1409ca(zzda zzdaVar, boolean z) {
        this.f13752b = zzdaVar;
        this.f13751a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean c2 = this.f13752b.f13672a.c();
        boolean B = this.f13752b.f13672a.B();
        this.f13752b.f13672a.a(this.f13751a);
        if (B == this.f13751a) {
            this.f13752b.f13672a.b().y().a("Default data collection state already set to", Boolean.valueOf(this.f13751a));
        }
        if (this.f13752b.f13672a.c() == c2 || this.f13752b.f13672a.c() != this.f13752b.f13672a.B()) {
            this.f13752b.f13672a.b().v().a("Default data collection is different than actual status", Boolean.valueOf(this.f13751a), Boolean.valueOf(c2));
        }
        this.f13752b.D();
    }
}
