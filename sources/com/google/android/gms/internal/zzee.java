package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public final class zzee {
    public final List<zzed> zzyW;
    public final long zzyX;
    public final List<String> zzyY;
    public final List<String> zzyZ;
    public final List<String> zzza;
    public final String zzzb;
    public final long zzzc;
    public final String zzzd;
    public final int zzze;
    public int zzzf;
    public int zzzg;

    public zzee(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (com.google.android.gms.ads.internal.util.client.zzb.a(2)) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Mediation Response JSON: " + jSONObject.toString(2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zzed zzedVar = new zzed(jSONArray.getJSONObject(i2));
            arrayList.add(zzedVar);
            if (i < 0 && zza(zzedVar)) {
                i = i2;
            }
        }
        this.zzzf = i;
        this.zzzg = jSONArray.length();
        this.zzyW = Collections.unmodifiableList(arrayList);
        this.zzzb = jSONObject.getString("qdata");
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject == null) {
            this.zzyX = -1L;
            this.zzyY = null;
            this.zzyZ = null;
            this.zzza = null;
            this.zzzc = -1L;
            this.zzzd = null;
            this.zzze = 0;
            return;
        }
        this.zzyX = optJSONObject.optLong("ad_network_timeout_millis", -1L);
        this.zzyY = com.google.android.gms.ads.internal.zzp.q().zza(optJSONObject, "click_urls");
        this.zzyZ = com.google.android.gms.ads.internal.zzp.q().zza(optJSONObject, "imp_urls");
        this.zzza = com.google.android.gms.ads.internal.zzp.q().zza(optJSONObject, "nofill_urls");
        long optLong = optJSONObject.optLong("refresh", -1L);
        this.zzzc = optLong > 0 ? optLong * 1000 : -1L;
        JSONArray optJSONArray = optJSONObject.optJSONArray("rewards");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            this.zzzd = null;
            this.zzze = 0;
        } else {
            this.zzzd = optJSONArray.getJSONObject(0).optString("rb_type");
            this.zzze = optJSONArray.getJSONObject(0).optInt("rb_amount");
        }
    }

    private boolean zza(zzed zzedVar) {
        Iterator<String> it = zzedVar.zzyO.iterator();
        while (it.hasNext()) {
            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
