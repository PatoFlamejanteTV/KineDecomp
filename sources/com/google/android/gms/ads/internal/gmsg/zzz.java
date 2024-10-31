package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbcl;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes.dex */
public final class zzz implements zzu<Object> {

    /* renamed from: a */
    @VisibleForTesting
    private final HashMap<String, zzbcl<JSONObject>> f10081a = new HashMap<>();

    public final Future<JSONObject> a(String str) {
        zzbcl<JSONObject> zzbclVar = new zzbcl<>();
        this.f10081a.put(str, zzbclVar);
        return zzbclVar;
    }

    public final void b(String str) {
        zzbcl<JSONObject> zzbclVar = this.f10081a.get(str);
        if (zzbclVar == null) {
            zzbbd.e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzbclVar.isDone()) {
            zzbclVar.cancel(true);
        }
        this.f10081a.remove(str);
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("request_id");
        String str2 = map.get("fetched_ad");
        zzbbd.zzdn("Received ad from the cache.");
        zzbcl<JSONObject> zzbclVar = this.f10081a.get(str);
        try {
            if (zzbclVar == null) {
                zzbbd.e("Could not find the ad request for the corresponding ad response.");
            } else {
                zzbclVar.set(new JSONObject(str2));
            }
        } catch (JSONException e2) {
            zzbbd.zzb("Failed constructing JSON object from value passed from javascript", e2);
            zzbclVar.set(null);
        } finally {
            this.f10081a.remove(str);
        }
    }
}
