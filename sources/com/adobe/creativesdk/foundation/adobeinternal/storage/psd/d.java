package com.adobe.creativesdk.foundation.adobeinternal.storage.psd;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobePSDUtils.java */
/* loaded from: classes.dex */
public class d {
    public static h a(Object obj) throws JSONException {
        if (obj.getClass() == JSONObject.class) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.length() < 4) {
                return new h(0.0f, 0.0f, 0.0f, 0.0f);
            }
            float f2 = (float) jSONObject.getDouble("left");
            float f3 = (float) jSONObject.getDouble("top");
            return new h(f2, f3, ((float) jSONObject.getDouble("right")) - f2, ((float) jSONObject.getDouble("bottom")) - f3);
        }
        if (obj instanceof Map) {
            return a((Map<String, Float>) obj);
        }
        return null;
    }

    public static h a(Map<String, Float> map) {
        if (map.size() < 4) {
            return new h();
        }
        float floatValue = map.get("left").floatValue();
        float floatValue2 = map.get("top").floatValue();
        return new h(floatValue, floatValue2, map.get("right").floatValue() - floatValue, map.get("bottom").floatValue() - floatValue2);
    }
}
