package com.facebook.internal;

import android.os.Bundle;
import com.facebook.internal.BundleJSONConverter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter.java */
/* loaded from: classes.dex */
final class h implements BundleJSONConverter.Setter {
    @Override // com.facebook.internal.BundleJSONConverter.Setter
    public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
        JSONArray jSONArray = (JSONArray) obj;
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONArray.length() == 0) {
            bundle.putStringArrayList(str, arrayList);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < jSONArray.length()) {
                Object obj2 = jSONArray.get(i2);
                if (obj2 instanceof String) {
                    arrayList.add((String) obj2);
                    i = i2 + 1;
                } else {
                    throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                }
            } else {
                bundle.putStringArrayList(str, arrayList);
                return;
            }
        }
    }

    @Override // com.facebook.internal.BundleJSONConverter.Setter
    public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
        throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
    }
}
