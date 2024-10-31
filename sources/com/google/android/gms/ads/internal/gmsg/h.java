package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.zzbbd;
import java.util.Map;

/* loaded from: classes.dex */
final class h implements zzu<Object> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        String valueOf = String.valueOf(map.get("string"));
        zzbbd.zzen(valueOf.length() != 0 ? "Received log message: ".concat(valueOf) : new String("Received log message: "));
    }
}
