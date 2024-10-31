package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements zzdk {

    /* renamed from: a */
    final /* synthetic */ zzaz f1655a;

    public l(zzaz zzazVar) {
        this.f1655a = zzazVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        if (this.f1655a.zzb(map) && map.containsKey("isVisible")) {
            this.f1655a.zzg(Boolean.valueOf(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("isVisible")) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(map.get("isVisible"))).booleanValue());
        }
    }
}
