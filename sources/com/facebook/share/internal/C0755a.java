package com.facebook.share.internal;

import com.facebook.share.internal.CameraEffectJSONUtility;
import com.facebook.share.model.CameraEffectArguments;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CameraEffectJSONUtility.java */
/* renamed from: com.facebook.share.internal.a */
/* loaded from: classes.dex */
class C0755a implements CameraEffectJSONUtility.Setter {
    @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
    public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException {
        builder.putArgument(str, (String) obj);
    }

    @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
    public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
        jSONObject.put(str, obj);
    }
}
