package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzu extends com.google.android.gms.analytics.zzi<zzu> {
    private final Map<String, Object> zztc = new HashMap();

    public final void set(String str, String str2) {
        Preconditions.b(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        Preconditions.a(str, (Object) "Name can not be empty or \"&\"");
        this.zztc.put(str, str2);
    }

    public final String toString() {
        return com.google.android.gms.analytics.zzi.zza((Object) this.zztc);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzu zzuVar) {
        zzu zzuVar2 = zzuVar;
        Preconditions.a(zzuVar2);
        zzuVar2.zztc.putAll(this.zztc);
    }

    public final Map<String, Object> zzbm() {
        return Collections.unmodifiableMap(this.zztc);
    }
}
