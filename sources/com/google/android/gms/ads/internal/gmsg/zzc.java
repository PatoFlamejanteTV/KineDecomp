package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbbd;
import java.util.Map;

@zzark
/* loaded from: classes.dex */
public final class zzc implements zzu<Object> {

    /* renamed from: a */
    private final zzd f10071a;

    public zzc(zzd zzdVar) {
        this.f10071a = zzdVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzbbd.zzeo("App event with no name parameter.");
        } else {
            this.f10071a.onAppEvent(str, map.get("info"));
        }
    }
}
