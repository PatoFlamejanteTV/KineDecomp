package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class Fa extends _a {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzfd f13633e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fa(zzfd zzfdVar, Q q) {
        super(q);
        this.f13633e = zzfdVar;
    }

    @Override // com.google.android.gms.measurement.internal._a
    public final void b() {
        zzfd zzfdVar = this.f13633e;
        zzfdVar.c();
        zzfdVar.b().y().a("Current session is expired, remove the session number and Id");
        if (zzfdVar.j().o(zzfdVar.n().z())) {
            zzfdVar.m().a("auto", "_sid", (Object) null, zzfdVar.a().a());
        }
        if (zzfdVar.j().p(zzfdVar.n().z())) {
            zzfdVar.m().a("auto", "_sno", (Object) null, zzfdVar.a().a());
        }
    }
}
