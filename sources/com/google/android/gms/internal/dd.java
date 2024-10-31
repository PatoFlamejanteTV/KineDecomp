package com.google.android.gms.internal;

import android.content.Context;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzgv f1497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(zzgv zzgvVar) {
        this.f1497a = zzgvVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        Object obj;
        zzin zzinVar;
        String str;
        zzin zzinVar2;
        String str2;
        String str3;
        obj = this.f1497a.zzpd;
        synchronized (obj) {
            zzinVar = this.f1497a.zzFP;
            if (zzinVar.isDone()) {
                return;
            }
            de deVar = new de(-2, map);
            str = this.f1497a.zzBY;
            if (!str.equals(deVar.g())) {
                StringBuilder append = new StringBuilder().append(deVar.g()).append(" ==== ");
                str3 = this.f1497a.zzBY;
                com.google.android.gms.ads.internal.util.client.zzb.e(append.append(str3).toString());
                return;
            }
            String d = deVar.d();
            if (d == null) {
                com.google.android.gms.ads.internal.util.client.zzb.e("URL missing in loadAdUrl GMSG.");
                return;
            }
            if (d.contains("%40mediation_adapters%40")) {
                Context context = zzizVar.getContext();
                String str4 = map.get("check_adapters");
                str2 = this.f1497a.zzFO;
                String replaceAll = d.replaceAll("%40mediation_adapters%40", zzhy.zza(context, str4, str2));
                deVar.a(replaceAll);
                com.google.android.gms.ads.internal.util.client.zzb.d("Ad request URL modified to " + replaceAll);
            }
            zzinVar2 = this.f1497a.zzFP;
            zzinVar2.zzf(deVar);
        }
    }
}
