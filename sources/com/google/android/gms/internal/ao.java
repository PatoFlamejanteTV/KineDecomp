package com.google.android.gms.internal;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes.dex */
final class ao implements zzdk {
    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        Uri uri;
        zzan zzhg;
        String str = map.get("u");
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzhg = zzizVar.zzhg();
        } catch (zzao e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Unable to append parameter to URL: " + str);
        }
        if (zzhg != null && zzhg.zzb(parse)) {
            uri = zzhg.zza(parse, zzizVar.getContext());
            new zzij(zzizVar.getContext(), zzizVar.zzhh().b, uri.toString()).zzfu();
        }
        uri = parse;
        new zzij(zzizVar.getContext(), zzizVar.zzhh().b, uri.toString()).zzfu();
    }
}
