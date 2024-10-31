package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class C implements Callable<List<Qa>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f13615a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13616b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f13617c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzby f13618d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(zzby zzbyVar, String str, String str2, String str3) {
        this.f13618d = zzbyVar;
        this.f13615a = str;
        this.f13616b = str2;
        this.f13617c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<Qa> call() throws Exception {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13618d.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13618d.f13986a;
        return zzfoVar2.i().a(this.f13615a, this.f13616b, this.f13617c);
    }
}
