package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ca;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXPushJournal.java */
/* loaded from: classes.dex */
public class Pa implements Ca.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0231f f4222a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pa(C0231f c0231f) {
        this.f4222a = c0231f;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ca.a
    public JSONObject create() {
        try {
            if (this.f4222a.r() == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("push-journal-format-version", 4);
                jSONObject.put("composite-href", "");
                jSONObject.put("deleted-components", new JSONObject());
                jSONObject.put("pending-delete-components", new JSONArray());
                jSONObject.put("immutable-path-to-href-lookup", new JSONObject());
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("push-journal-format-version", 4);
            jSONObject2.put("composite-href", this.f4222a.r().toString());
            jSONObject2.put("uploaded-components", new JSONObject());
            jSONObject2.put("deleted-components", new JSONObject());
            jSONObject2.put("pending-delete-components", new JSONArray());
            jSONObject2.put("immutable-path-to-href-lookup", new JSONObject());
            return jSONObject2;
        } catch (JSONException unused) {
            return null;
        }
    }
}
