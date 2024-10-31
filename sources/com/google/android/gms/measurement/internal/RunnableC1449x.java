package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1449x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzo f13870a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzk f13871b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzby f13872c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1449x(zzby zzbyVar, zzo zzoVar, zzk zzkVar) {
        this.f13872c = zzbyVar;
        this.f13870a = zzoVar;
        this.f13871b = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13872c.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13872c.f13986a;
        zzfoVar2.b(this.f13870a, this.f13871b);
    }
}
