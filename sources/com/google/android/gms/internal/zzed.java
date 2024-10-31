package com.google.android.gms.internal;

import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public final class zzed {
    public final String zzyM;
    public final String zzyN;
    public final List<String> zzyO;
    public final String zzyP;
    public final String zzyQ;
    public final List<String> zzyR;
    public final List<String> zzyS;
    public final String zzyT;
    public final List<String> zzyU;
    public final List<String> zzyV;

    public zzed(JSONObject jSONObject) throws JSONException {
        this.zzyN = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzyO = Collections.unmodifiableList(arrayList);
        this.zzyP = jSONObject.optString("allocation_id", null);
        this.zzyR = com.google.android.gms.ads.internal.zzp.q().zza(jSONObject, "clickurl");
        this.zzyS = com.google.android.gms.ads.internal.zzp.q().zza(jSONObject, "imp_urls");
        this.zzyU = com.google.android.gms.ads.internal.zzp.q().zza(jSONObject, "video_start_urls");
        this.zzyV = com.google.android.gms.ads.internal.zzp.q().zza(jSONObject, "video_complete_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.zzyM = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA);
        this.zzyT = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzyQ = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
    }
}
