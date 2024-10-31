package com.google.android.gms.internal;

import java.util.Map;

/* loaded from: classes.dex */
final class ap implements zzdk {
    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        com.google.android.gms.ads.internal.overlay.zzd zzhc = zzizVar.zzhc();
        if (zzhc != null) {
            zzhc.a();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzd zzhd = zzizVar.zzhd();
        if (zzhd != null) {
            zzhd.a();
        } else {
            com.google.android.gms.ads.internal.util.client.zzb.e("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
