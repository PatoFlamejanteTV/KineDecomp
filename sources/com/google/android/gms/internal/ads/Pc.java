package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Pc implements zzbcq<zzajr> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Oc f11746a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pc(Oc oc) {
        this.f11746a = oc;
    }

    @Override // com.google.android.gms.internal.ads.zzbcq
    public final /* synthetic */ void zzh(zzajr zzajrVar) {
        com.google.android.gms.ads.internal.gmsg.zzz zzzVar;
        try {
            zzajrVar.zzb("AFMA_getAdapterLessMediationAd", this.f11746a.f11728a);
        } catch (Exception e2) {
            zzbbd.zzb("Error requesting an ad url", e2);
            zzzVar = zzatd.zzdzv;
            zzzVar.b(this.f11746a.f11729b);
        }
    }
}
