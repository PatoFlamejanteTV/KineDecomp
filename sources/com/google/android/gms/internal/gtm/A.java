package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class A implements zzbp<zzcc> {

    /* renamed from: a, reason: collision with root package name */
    private final zzap f13122a;

    /* renamed from: b, reason: collision with root package name */
    private final zzcc f13123b = new zzcc();

    public A(zzap zzapVar) {
        this.f13122a = zzapVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zza(String str, boolean z) {
        if ("ga_dryRun".equals(str)) {
            this.f13123b.zzaay = z ? 1 : 0;
        } else {
            this.f13122a.zzco().zzd("Bool xml configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.f13123b.zzaax = i;
        } else {
            this.f13122a.zzco().zzd("Int xml configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, String str2) {
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzc(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.f13123b.zzaau = str2;
            return;
        }
        if ("ga_appVersion".equals(str)) {
            this.f13123b.zzaav = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.f13123b.zzaaw = str2;
        } else {
            this.f13122a.zzco().zzd("String xml configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final /* synthetic */ zzcc zzel() {
        return this.f13123b;
    }
}
