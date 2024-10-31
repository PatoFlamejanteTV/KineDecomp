package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.ta, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1442ta implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f13853a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzfv f13854b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzk f13855c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzeb f13856d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1442ta(zzeb zzebVar, boolean z, zzfv zzfvVar, zzk zzkVar) {
        this.f13856d = zzebVar;
        this.f13853a = z;
        this.f13854b = zzfvVar;
        this.f13855c = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar;
        zzajVar = this.f13856d.f14019d;
        if (zzajVar == null) {
            this.f13856d.b().q().a("Discarding data. Failed to set user attribute");
        } else {
            this.f13856d.a(zzajVar, this.f13853a ? null : this.f13854b, this.f13855c);
            this.f13856d.E();
        }
    }
}
