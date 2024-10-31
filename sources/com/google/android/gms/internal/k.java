package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzaz f1654a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(zzaz zzazVar) {
        this.f1654a = zzazVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        zzax zzaxVar;
        if (this.f1654a.zzb(map)) {
            StringBuilder append = new StringBuilder().append("Received request to untrack: ");
            zzaxVar = this.f1654a.zzre;
            com.google.android.gms.ads.internal.util.client.zzb.a(append.append(zzaxVar.zzbX()).toString());
            this.f1654a.destroy();
        }
    }
}
