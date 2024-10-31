package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class M implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzk f13661a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzby f13662b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(zzby zzbyVar, zzk zzkVar) {
        this.f13662b = zzbyVar;
        this.f13661a = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13662b.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13662b.f13986a;
        zzfoVar2.c(this.f13661a);
    }
}
