package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1443u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzcz f13857a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbw f13858b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1443u(zzbw zzbwVar, zzcz zzczVar) {
        this.f13858b = zzbwVar;
        this.f13857a = zzczVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13858b.a(this.f13857a);
        this.f13858b.d();
    }
}
