package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.ha, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1419ha implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzdx f13771a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzdy f13772b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1419ha(zzdy zzdyVar, zzdx zzdxVar) {
        this.f13772b = zzdyVar;
        this.f13771a = zzdxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13772b.a(this.f13771a, false);
        zzdy zzdyVar = this.f13772b;
        zzdyVar.f14012c = null;
        zzdyVar.o().a((zzdx) null);
    }
}
