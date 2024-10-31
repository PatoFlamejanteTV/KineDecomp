package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class N implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f13665a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13666b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f13667c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ long f13668d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzby f13669e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(zzby zzbyVar, String str, String str2, String str3, long j) {
        this.f13669e = zzbyVar;
        this.f13665a = str;
        this.f13666b = str2;
        this.f13667c = str3;
        this.f13668d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar;
        zzfo zzfoVar2;
        String str = this.f13665a;
        if (str != null) {
            zzdx zzdxVar = new zzdx(this.f13667c, str, this.f13668d);
            zzfoVar = this.f13669e.f13986a;
            zzfoVar.p().k().a(this.f13666b, zzdxVar);
        } else {
            zzfoVar2 = this.f13669e.f13986a;
            zzfoVar2.p().k().a(this.f13666b, (zzdx) null);
        }
    }
}
