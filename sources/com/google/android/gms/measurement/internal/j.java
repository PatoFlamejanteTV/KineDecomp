package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class J implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzfv f13649a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzk f13650b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzby f13651c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(zzby zzbyVar, zzfv zzfvVar, zzk zzkVar) {
        this.f13651c = zzbyVar;
        this.f13649a = zzfvVar;
        this.f13650b = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13651c.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13651c.f13986a;
        zzfoVar2.b(this.f13649a, this.f13650b);
    }
}
