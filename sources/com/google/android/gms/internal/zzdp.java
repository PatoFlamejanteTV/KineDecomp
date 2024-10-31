package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzdp implements zzdk {
    final HashMap<String, zzin<JSONObject>> zzxP = new HashMap<>();

    public Future<JSONObject> zzY(String str) {
        zzin<JSONObject> zzinVar = new zzin<>();
        this.zzxP.put(str, zzinVar);
        return zzinVar;
    }

    public void zzZ(String str) {
        zzin<JSONObject> zzinVar = this.zzxP.get(str);
        if (zzinVar == null) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzinVar.isDone()) {
            zzinVar.cancel(true);
        }
        this.zzxP.remove(str);
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        zzf(map.get("request_id"), map.get("fetched_ad"));
    }

    public void zzf(String str, String str2) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Received ad from the cache.");
        zzin<JSONObject> zzinVar = this.zzxP.get(str);
        if (zzinVar == null) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            zzinVar.zzf(new JSONObject(str2));
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed constructing JSON object from value passed from javascript", e);
            zzinVar.zzf(null);
        } finally {
            this.zzxP.remove(str);
        }
    }
}
