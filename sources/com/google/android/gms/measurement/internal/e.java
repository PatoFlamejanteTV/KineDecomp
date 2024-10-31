package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class E implements Callable<List<zzo>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f13626a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13627b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f13628c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzby f13629d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(zzby zzbyVar, String str, String str2, String str3) {
        this.f13629d = zzbyVar;
        this.f13626a = str;
        this.f13627b = str2;
        this.f13628c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzo> call() throws Exception {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13629d.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13629d.f13986a;
        return zzfoVar2.i().b(this.f13626a, this.f13627b, this.f13628c);
    }
}
