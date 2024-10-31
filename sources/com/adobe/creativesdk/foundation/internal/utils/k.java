package com.adobe.creativesdk.foundation.internal.utils;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeJSONObject.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    JSONObject f6867a;

    public k(String str) throws JSONException {
        this.f6867a = new JSONObject(str);
    }

    public String a(String str) {
        if (!this.f6867a.has(str)) {
            return null;
        }
        try {
            return this.f6867a.getString(str);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, k.class.getName(), "Error during getString operation", e2);
            return null;
        }
    }

    public boolean b(String str) {
        return this.f6867a.has(str);
    }

    public String toString() {
        return this.f6867a.toString();
    }
}
