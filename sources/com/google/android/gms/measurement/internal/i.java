package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class I implements Callable<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzag f13644a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13645b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzby f13646c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(zzby zzbyVar, zzag zzagVar, String str) {
        this.f13646c = zzbyVar;
        this.f13644a = zzagVar;
        this.f13645b = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13646c.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13646c.f13986a;
        return zzfoVar2.k().a(this.f13644a, this.f13645b);
    }
}
