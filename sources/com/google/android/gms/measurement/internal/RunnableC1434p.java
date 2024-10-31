package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1434p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbw f13811a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzas f13812b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1434p(zzbm zzbmVar, zzbw zzbwVar, zzas zzasVar) {
        this.f13811a = zzbwVar;
        this.f13812b = zzasVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13811a.t() == null) {
            this.f13812b.q().a("Install Referrer Reporter is null");
            return;
        }
        zzbj t = this.f13811a.t();
        t.f13963a.f();
        t.a(t.f13963a.getContext().getPackageName());
    }
}
