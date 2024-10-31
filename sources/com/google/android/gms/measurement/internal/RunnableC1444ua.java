package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.ua, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1444ua implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaj f13859a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzes f13860b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1444ua(zzes zzesVar, zzaj zzajVar) {
        this.f13860b = zzesVar;
        this.f13859a = zzajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f13860b) {
            zzes.a(this.f13860b, false);
            if (!this.f13860b.f14026c.z()) {
                this.f13860b.f14026c.b().y().a("Connected to service");
                this.f13860b.f14026c.a(this.f13859a);
            }
        }
    }
}
