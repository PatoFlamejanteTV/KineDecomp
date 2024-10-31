package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.wa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1448wa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaj f13868a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzes f13869b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1448wa(zzes zzesVar, zzaj zzajVar) {
        this.f13869b = zzesVar;
        this.f13868a = zzajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f13869b) {
            zzes.a(this.f13869b, false);
            if (!this.f13869b.f14026c.z()) {
                this.f13869b.f14026c.b().x().a("Connected to remote service");
                this.f13869b.f14026c.a(this.f13868a);
            }
        }
    }
}
