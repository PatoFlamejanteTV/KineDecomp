package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class L implements Callable<List<Qa>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzk f13658a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzby f13659b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(zzby zzbyVar, zzk zzkVar) {
        this.f13659b = zzbyVar;
        this.f13658a = zzkVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<Qa> call() throws Exception {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13659b.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13659b.f13986a;
        return zzfoVar2.i().a(this.f13658a.f14064a);
    }
}
