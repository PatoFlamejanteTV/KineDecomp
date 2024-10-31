package com.facebook.internal;

import android.os.Bundle;
import com.facebook.internal.BundleJSONConverter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter.java */
/* loaded from: classes.dex */
final class g implements BundleJSONConverter.Setter {
    @Override // com.facebook.internal.BundleJSONConverter.Setter
    public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
        throw new IllegalArgumentException("Unexpected type from JSON");
    }

    @Override // com.facebook.internal.BundleJSONConverter.Setter
    public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str2 : (String[]) obj) {
            jSONArray.put(str2);
        }
        jSONObject.put(str, jSONArray);
    }
}
