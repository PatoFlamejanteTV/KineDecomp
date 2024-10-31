package com.adobe.creativesdk.foundation.adobeinternal.storage.psd;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobePSDPreviewLayerComp.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private String f4677a;

    /* renamed from: b */
    private int f4678b;

    public b(JSONObject jSONObject) {
        try {
            this.f4677a = jSONObject.getString("name");
            this.f4678b = jSONObject.getInt("id");
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePSDPreviewLayerComp.Constructor", e2.getMessage());
        }
    }
}
