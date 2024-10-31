package com.facebook.internal;

import android.os.Bundle;
import com.facebook.internal.BundleJSONConverter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter.java */
/* renamed from: com.facebook.internal.h */
/* loaded from: classes.dex */
class C0738h implements BundleJSONConverter.Setter {
    @Override // com.facebook.internal.BundleJSONConverter.Setter
    public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
        JSONArray jSONArray = (JSONArray) obj;
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONArray.length() == 0) {
            bundle.putStringArrayList(str, arrayList);
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj2 = jSONArray.get(i);
            if (obj2 instanceof String) {
                arrayList.add((String) obj2);
            } else {
                throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
            }
        }
        bundle.putStringArrayList(str, arrayList);
    }

    @Override // com.facebook.internal.BundleJSONConverter.Setter
    public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
        throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
    }
}
