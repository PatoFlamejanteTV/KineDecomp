package com.google.android.gms.internal;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzej {
    public List<String> zza(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void zza(Context context, String str, zzhs zzhsVar, String str2, boolean z, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String str3 = z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String replaceAll = it.next().replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", zzhsVar.zzHx.zzzb).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", com.google.android.gms.ads.internal.zzp.h().getSessionId()).replaceAll("@gw_seqnum@", zzhsVar.zzEq);
            if (zzhsVar.zzzu != null) {
                replaceAll = replaceAll.replaceAll("@gw_adnetid@", zzhsVar.zzzu.zzyN).replaceAll("@gw_allocid@", zzhsVar.zzzu.zzyP);
            }
            new zzij(context, str, replaceAll).zzfu();
        }
    }
}
