package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzis;

/* loaded from: classes.dex */
class f implements zzis.zzc<zzbe> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f631a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f631a = eVar;
    }

    @Override // com.google.android.gms.internal.zzis.zzc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzc(zzbe zzbeVar) {
        try {
            zzbeVar.zza("AFMA_getAdapterLessMediationAd", this.f631a.f630a);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Error requesting an ad url", e);
            zzm.a().zzZ(this.f631a.b);
        }
    }
}
