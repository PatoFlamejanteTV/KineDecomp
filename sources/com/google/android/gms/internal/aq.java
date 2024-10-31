package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import java.util.Map;

/* loaded from: classes.dex */
final class aq implements zzdk {
    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        zzizVar.zzD(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close")));
    }
}
