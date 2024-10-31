package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@zzgr
/* loaded from: classes.dex */
public class zzdq implements zzdk {
    static final Map<String, Integer> zzxS = new HashMap();
    private final com.google.android.gms.ads.internal.zze zzxQ;
    private final zzfc zzxR;

    static {
        zzxS.put("resize", 1);
        zzxS.put("playVideo", 2);
        zzxS.put("storePicture", 3);
        zzxS.put("createCalendarEvent", 4);
        zzxS.put("setOrientationProperties", 5);
        zzxS.put("closeResizedAd", 6);
    }

    public zzdq(com.google.android.gms.ads.internal.zze zzeVar, zzfc zzfcVar) {
        this.zzxQ = zzeVar;
        this.zzxR = zzfcVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        int intValue = zzxS.get(map.get("a")).intValue();
        if (intValue != 5 && this.zzxQ != null && !this.zzxQ.b()) {
            this.zzxQ.a((String) null);
            return;
        }
        switch (intValue) {
            case 1:
                this.zzxR.zzg(map);
                return;
            case 2:
            default:
                com.google.android.gms.ads.internal.util.client.zzb.c("Unknown MRAID command called.");
                return;
            case 3:
                new zzfe(zzizVar, map).execute();
                return;
            case 4:
                new zzfb(zzizVar, map).execute();
                return;
            case 5:
                new zzfd(zzizVar, map).execute();
                return;
            case 6:
                this.zzxR.zzn(true);
                return;
        }
    }
}
