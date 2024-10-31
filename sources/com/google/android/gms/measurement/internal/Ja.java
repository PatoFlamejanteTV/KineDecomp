package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ja extends _a {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzfo f13652e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzfk f13653f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ja(zzfk zzfkVar, Q q, zzfo zzfoVar) {
        super(q);
        this.f13653f = zzfkVar;
        this.f13652e = zzfoVar;
    }

    @Override // com.google.android.gms.measurement.internal._a
    public final void b() {
        this.f13653f.r();
        this.f13653f.b().y().a("Starting upload from DelayedRunnable");
        this.f13652e.m();
    }
}
