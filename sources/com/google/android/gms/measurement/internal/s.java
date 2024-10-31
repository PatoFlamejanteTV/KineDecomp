package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
public final class S implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ long f13683a;

    /* renamed from: b */
    private final /* synthetic */ zza f13684b;

    public S(zza zzaVar, long j) {
        this.f13684b = zzaVar;
        this.f13683a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13684b.b(this.f13683a);
    }
}
