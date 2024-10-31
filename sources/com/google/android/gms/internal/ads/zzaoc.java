package com.google.android.gms.internal.ads;

import java.util.Map;

@zzark
/* loaded from: classes2.dex */
public final class zzaoc {
    private final zzbgg zzdin;
    private final boolean zzdpt;
    private final String zzdpu;

    public zzaoc(zzbgg zzbggVar, Map<String, String> map) {
        this.zzdin = zzbggVar;
        this.zzdpu = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzdpt = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzdpt = true;
        }
    }

    public final void execute() {
        int zzzy;
        if (this.zzdin == null) {
            zzbbd.zzeo("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.zzdpu)) {
            zzzy = com.google.android.gms.ads.internal.zzbv.g().zzzx();
        } else if ("landscape".equalsIgnoreCase(this.zzdpu)) {
            zzzy = com.google.android.gms.ads.internal.zzbv.g().zzzw();
        } else {
            zzzy = this.zzdpt ? -1 : com.google.android.gms.ads.internal.zzbv.g().zzzy();
        }
        this.zzdin.setRequestedOrientation(zzzy);
    }
}
