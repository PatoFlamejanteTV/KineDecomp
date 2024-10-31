package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class H implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzag f13639a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13640b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzby f13641c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(zzby zzbyVar, zzag zzagVar, String str) {
        this.f13641c = zzbyVar;
        this.f13639a = zzagVar;
        this.f13640b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzfoVar = this.f13641c.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13641c.f13986a;
        zzfoVar2.a(this.f13639a, this.f13640b);
    }
}
