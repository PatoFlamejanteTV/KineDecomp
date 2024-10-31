package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzatl implements com.google.android.gms.ads.internal.gmsg.zzu<Object> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        com.google.android.gms.ads.internal.gmsg.zzz zzzVar;
        String str = map.get("request_id");
        String valueOf = String.valueOf(map.get("errors"));
        zzbbd.zzeo(valueOf.length() != 0 ? "Invalid request: ".concat(valueOf) : new String("Invalid request: "));
        zzzVar = zzatd.zzdzv;
        zzzVar.b(str);
    }
}
