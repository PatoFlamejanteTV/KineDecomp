package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.ads.internal.formats.zzf f1484a;
    final /* synthetic */ zzgm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(zzgm zzgmVar, com.google.android.gms.ads.internal.formats.zzf zzfVar) {
        this.b = zzgmVar;
        this.f1484a = zzfVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        this.b.zzb(this.f1484a, map.get("asset"));
    }
}
