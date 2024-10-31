package com.facebook.share.internal;

import com.facebook.share.internal.CameraEffectJSONUtility;
import com.facebook.share.model.CameraEffectArguments;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CameraEffectJSONUtility.java */
/* renamed from: com.facebook.share.internal.b */
/* loaded from: classes.dex */
class C0756b implements CameraEffectJSONUtility.Setter {
    @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
    public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException {
        throw new IllegalArgumentException("Unexpected type from JSON");
    }

    @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
    public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str2 : (String[]) obj) {
            jSONArray.put(str2);
        }
        jSONObject.put(str, jSONArray);
    }
}
