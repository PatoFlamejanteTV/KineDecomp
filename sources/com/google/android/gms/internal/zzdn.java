package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import java.util.Map;

@zzgr
/* loaded from: classes.dex */
public class zzdn implements zzdk {
    private final zzdo zzxO;

    public zzdn(zzdo zzdoVar) {
        this.zzxO = zzdoVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        float f;
        boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("transparentBackground"));
        boolean equals2 = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("blur"));
        try {
        } catch (NumberFormatException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Fail to parse float", e);
        }
        if (map.get("blurRadius") != null) {
            f = Float.parseFloat(map.get("blurRadius"));
            this.zzxO.zzd(equals);
            this.zzxO.zza(equals2, f);
        }
        f = 0.0f;
        this.zzxO.zzd(equals);
        this.zzxO.zza(equals2, f);
    }
}
