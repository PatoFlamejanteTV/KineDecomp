package com.google.android.gms.internal;

import java.util.Map;

@zzgr
/* loaded from: classes.dex */
public class zzdw implements zzdk {
    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        int i;
        zzdu r = com.google.android.gms.ads.internal.zzp.r();
        if (map.containsKey("abort")) {
            if (r.zza(zzizVar)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzb.e("Precache abort but no preload task running.");
            return;
        }
        String str = map.get("src");
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Precache video action is missing the src parameter.");
            return;
        }
        try {
            i = Integer.parseInt(map.get("player"));
        } catch (NumberFormatException e) {
            i = 0;
        }
        String str2 = map.containsKey("mimetype") ? map.get("mimetype") : "";
        if (r.zzb(zzizVar)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Precache task already running.");
        } else {
            com.google.android.gms.common.internal.zzb.a(zzizVar.zzhb());
            new zzdt(zzizVar, zzizVar.zzhb().f655a.zza(zzizVar, i, str2), str).zzfu();
        }
    }
}
