package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzjl extends com.google.android.gms.measurement.zze<zzjl> {
    private Map<Integer, String> zzMg = new HashMap(4);

    public String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, String> entry : this.zzMg.entrySet()) {
            hashMap.put("dimension" + entry.getKey(), entry.getValue());
        }
        return zzB(hashMap);
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzjl zzjlVar) {
        zzjlVar.zzMg.putAll(this.zzMg);
    }

    public Map<Integer, String> zzhX() {
        return Collections.unmodifiableMap(this.zzMg);
    }
}
