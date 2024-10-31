package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class G implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzag f13634a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzk f13635b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzby f13636c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(zzby zzbyVar, zzag zzagVar, zzk zzkVar) {
        this.f13636c = zzbyVar;
        this.f13634a = zzagVar;
        this.f13635b = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        zzag b2 = this.f13636c.b(this.f13634a, this.f13635b);
        zzfoVar = this.f13636c.f13986a;
        zzfoVar.n();
        zzfoVar2 = this.f13636c.f13986a;
        zzfoVar2.a(b2, this.f13635b);
    }
}
