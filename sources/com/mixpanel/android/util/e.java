package com.mixpanel.android.util;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSONUtils.java */
/* loaded from: classes.dex */
public class e {
    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }
}
