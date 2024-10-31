package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzcf {
    private final zzcg zzoo;
    private final Map<String, zzce> zzvQ = new HashMap();

    public zzcf(zzcg zzcgVar) {
        this.zzoo = zzcgVar;
    }

    public void zza(String str, zzce zzceVar) {
        this.zzvQ.put(str, zzceVar);
    }

    public void zza(String str, String str2, long j) {
        zzcc.zza(this.zzoo, this.zzvQ.get(str2), j, str);
        this.zzvQ.put(str, zzcc.zza(this.zzoo, j));
    }

    public zzcg zzdm() {
        return this.zzoo;
    }
}
