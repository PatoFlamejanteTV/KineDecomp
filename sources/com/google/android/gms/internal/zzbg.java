package com.google.android.gms.internal;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzbg implements zzbf {
    private final zzbe zzrL;
    private final HashSet<AbstractMap.SimpleEntry<String, zzdk>> zzrM = new HashSet<>();

    public zzbg(zzbe zzbeVar) {
        this.zzrL = zzbeVar;
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zza(String str, zzdk zzdkVar) {
        this.zzrL.zza(str, zzdkVar);
        this.zzrM.add(new AbstractMap.SimpleEntry<>(str, zzdkVar));
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zza(String str, String str2) {
        this.zzrL.zza(str, str2);
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zza(String str, JSONObject jSONObject) {
        this.zzrL.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zzb(String str, zzdk zzdkVar) {
        this.zzrL.zzb(str, zzdkVar);
        this.zzrM.remove(new AbstractMap.SimpleEntry(str, zzdkVar));
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zzb(String str, JSONObject jSONObject) {
        this.zzrL.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzbf
    public void zzck() {
        Iterator<AbstractMap.SimpleEntry<String, zzdk>> it = this.zzrM.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, zzdk> next = it.next();
            com.google.android.gms.ads.internal.util.client.zzb.d("Unregistering eventhandler: " + next.getValue().toString());
            this.zzrL.zzb(next.getKey(), next.getValue());
        }
        this.zzrM.clear();
    }
}
