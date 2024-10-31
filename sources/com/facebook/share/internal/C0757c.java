package com.facebook.share.internal;

import com.facebook.share.internal.CameraEffectJSONUtility;
import com.facebook.share.model.CameraEffectArguments;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CameraEffectJSONUtility.java */
/* renamed from: com.facebook.share.internal.c */
/* loaded from: classes.dex */
class C0757c implements CameraEffectJSONUtility.Setter {
    @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
    public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException {
        JSONArray jSONArray = (JSONArray) obj;
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj2 = jSONArray.get(i);
            if (obj2 instanceof String) {
                strArr[i] = (String) obj2;
            } else {
                throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
            }
        }
        builder.putArgument(str, strArr);
    }

    @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
    public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
        throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
    }
}
