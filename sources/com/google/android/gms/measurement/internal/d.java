package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class D implements Callable<List<zzo>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzk f13621a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13622b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f13623c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzby f13624d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(zzby zzbyVar, zzk zzkVar, String str, String str2) {
        this.f13624d = zzbyVar;
        this.f13621a = zzkVar;
        this.f13622b = str;
        this.f13623c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzo> call() throws Exception {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13624d.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13624d.f13986a;
        return zzfoVar2.i().b(this.f13621a.f14064a, this.f13622b, this.f13623c);
    }
}
