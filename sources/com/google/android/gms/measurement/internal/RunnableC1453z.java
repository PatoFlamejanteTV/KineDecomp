package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1453z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzo f13878a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzby f13879b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1453z(zzby zzbyVar, zzo zzoVar) {
        this.f13879b = zzbyVar;
        this.f13878a = zzoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13879b.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13879b.f13986a;
        zzfoVar2.b(this.f13878a);
    }
}
