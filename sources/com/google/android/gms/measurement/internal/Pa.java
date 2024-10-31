package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Pa implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzk f13675a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzfo f13676b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pa(zzfo zzfoVar, zzk zzkVar) {
        this.f13676b = zzfoVar;
        this.f13675a = zzkVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        Sa b2;
        if (!this.f13676b.f().i(this.f13675a.f14064a)) {
            b2 = this.f13676b.i().b(this.f13675a.f14064a);
        } else {
            b2 = this.f13676b.e(this.f13675a);
        }
        if (b2 == null) {
            this.f13676b.b().t().a("App info was null when attempting to get app instance id");
            return null;
        }
        return b2.a();
    }
}
