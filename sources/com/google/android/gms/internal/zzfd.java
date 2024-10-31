package com.google.android.gms.internal;

import java.util.Map;

@zzgr
/* loaded from: classes.dex */
public class zzfd {
    private final boolean zzAq;
    private final String zzAr;
    private final zziz zzoM;

    public zzfd(zziz zzizVar, Map<String, String> map) {
        this.zzoM = zzizVar;
        this.zzAr = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzAq = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzAq = true;
        }
    }

    public void execute() {
        if (this.zzoM == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("AdWebView is null");
        } else {
            this.zzoM.setRequestedOrientation("portrait".equalsIgnoreCase(this.zzAr) ? com.google.android.gms.ads.internal.zzp.g().zzgH() : "landscape".equalsIgnoreCase(this.zzAr) ? com.google.android.gms.ads.internal.zzp.g().zzgG() : this.zzAq ? -1 : com.google.android.gms.ads.internal.zzp.g().zzgI());
        }
    }
}
