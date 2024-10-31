package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1445v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzk f13861a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzby f13862b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1445v(zzby zzbyVar, zzk zzkVar) {
        this.f13862b = zzbyVar;
        this.f13861a = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13862b.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13862b.f13986a;
        zzfoVar2.b(this.f13861a);
    }
}
