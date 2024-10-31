package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class F implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzk f13631a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzby f13632b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(zzby zzbyVar, zzk zzkVar) {
        this.f13632b = zzbyVar;
        this.f13631a = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13632b.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13632b.f13986a;
        zzfoVar2.a(this.f13631a);
    }
}
