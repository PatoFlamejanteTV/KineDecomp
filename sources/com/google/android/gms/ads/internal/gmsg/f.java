package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;

/* loaded from: classes.dex */
final class f implements zzu<zzbgg> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbggVar, Map map) {
        zzbgg zzbggVar2 = zzbggVar;
        com.google.android.gms.ads.internal.overlay.zzd zzadh = zzbggVar2.zzadh();
        if (zzadh != null) {
            zzadh.A();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzd zzadi = zzbggVar2.zzadi();
        if (zzadi != null) {
            zzadi.A();
        } else {
            zzbbd.zzeo("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
