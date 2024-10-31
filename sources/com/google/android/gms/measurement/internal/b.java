package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class B implements Callable<List<Qa>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzk f13608a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13609b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f13610c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzby f13611d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(zzby zzbyVar, zzk zzkVar, String str, String str2) {
        this.f13611d = zzbyVar;
        this.f13608a = zzkVar;
        this.f13609b = str;
        this.f13610c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<Qa> call() throws Exception {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13611d.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13611d.f13986a;
        return zzfoVar2.i().a(this.f13608a.f14064a, this.f13609b, this.f13610c);
    }
}
