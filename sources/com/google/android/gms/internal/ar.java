package com.google.android.gms.internal;

import java.util.Map;

/* loaded from: classes.dex */
final class ar implements zzdk {
    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        String str = map.get("u");
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("URL missing from httpTrack GMSG.");
        } else {
            new zzij(zzizVar.getContext(), zzizVar.zzhh().b, str).zzfu();
        }
    }
}
