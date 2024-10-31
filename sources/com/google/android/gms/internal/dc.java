package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzgv f1496a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(zzgv zzgvVar) {
        this.f1496a = zzgvVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        Object obj;
        zzin zzinVar;
        String str;
        zzin zzinVar2;
        obj = this.f1496a.zzpd;
        synchronized (obj) {
            zzinVar = this.f1496a.zzFP;
            if (zzinVar.isDone()) {
                return;
            }
            str = this.f1496a.zzBY;
            if (str.equals(map.get("request_id"))) {
                de deVar = new de(1, map);
                com.google.android.gms.ads.internal.util.client.zzb.e("Invalid " + deVar.e() + " request error: " + deVar.b());
                zzinVar2 = this.f1496a.zzFP;
                zzinVar2.zzf(deVar);
            }
        }
    }
}
