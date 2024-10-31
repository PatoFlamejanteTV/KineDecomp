package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzbac {
    private static final zzbae<Map<String, ?>> zzeni = new Xd();

    public static List<String> zza(JSONArray jSONArray, List<String> list) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static JSONObject zza(JSONObject jSONObject, String... strArr) {
        int i = 0;
        while (true) {
            if (i >= strArr.length - 1) {
                break;
            }
            if (jSONObject == null) {
                jSONObject = null;
                break;
            }
            jSONObject = jSONObject.optJSONObject(strArr[i]);
            i++;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject(strArr[strArr.length - 1]);
    }
}
