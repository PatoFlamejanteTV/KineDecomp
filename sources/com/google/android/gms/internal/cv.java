package com.google.android.gms.internal;

import com.google.android.gms.internal.zzis;

/* loaded from: classes.dex */
class cv implements zzis.zzc<zzbe> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzce f1488a;
    final /* synthetic */ cu b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cu cuVar, zzce zzceVar) {
        this.b = cuVar;
        this.f1488a = zzceVar;
    }

    @Override // com.google.android.gms.internal.zzis.zzc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzc(zzbe zzbeVar) {
        this.b.c.zza(this.f1488a, "jsf");
        this.b.c.zzdo();
        zzbeVar.zza("/invalidRequest", this.b.b.zzFR);
        zzbeVar.zza("/loadAdURL", this.b.b.zzFS);
        try {
            zzbeVar.zza("AFMA_buildAdURL", this.b.e);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Error requesting an ad url", e);
        }
    }
}
