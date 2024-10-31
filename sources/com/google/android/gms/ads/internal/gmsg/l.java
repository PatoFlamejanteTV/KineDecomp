package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;

/* loaded from: classes.dex */
final class l implements zzu<zzbgg> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbggVar, Map map) {
        zzbgg zzbggVar2 = zzbggVar;
        if (map.keySet().contains("start")) {
            zzbggVar2.zzadl().zzaeh();
        } else if (map.keySet().contains("stop")) {
            zzbggVar2.zzadl().zzaei();
        } else if (map.keySet().contains("cancel")) {
            zzbggVar2.zzadl().zzaej();
        }
    }
}
