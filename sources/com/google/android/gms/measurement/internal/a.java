package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class A implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzo f13605a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzby f13606b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(zzby zzbyVar, zzo zzoVar) {
        this.f13606b = zzbyVar;
        this.f13605a = zzoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13606b.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13606b.f13986a;
        zzfoVar2.a(this.f13605a);
    }
}
