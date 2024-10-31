package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1451y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzo f13874a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzk f13875b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzby f13876c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1451y(zzby zzbyVar, zzo zzoVar, zzk zzkVar) {
        this.f13876c = zzbyVar;
        this.f13874a = zzoVar;
        this.f13875b = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13876c.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13876c.f13986a;
        zzfoVar2.a(this.f13874a, this.f13875b);
    }
}
