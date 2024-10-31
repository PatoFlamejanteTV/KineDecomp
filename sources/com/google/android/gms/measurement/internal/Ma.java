package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ma implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzft f13663a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzfo f13664b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma(zzfo zzfoVar, zzft zzftVar) {
        this.f13664b = zzfoVar;
        this.f13663a = zzftVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13664b.a(this.f13663a);
        this.f13664b.c();
    }
}
