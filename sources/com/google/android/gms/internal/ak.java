package com.google.android.gms.internal;

import java.util.Map;

/* loaded from: classes.dex */
final class ak implements zzdk {
    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        String str = map.get("tx");
        String str2 = map.get("ty");
        String str3 = map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzan zzhg = zzizVar.zzhg();
            if (zzhg != null) {
                zzhg.zzab().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not parse touch parameters from gmsg.");
        }
    }
}
