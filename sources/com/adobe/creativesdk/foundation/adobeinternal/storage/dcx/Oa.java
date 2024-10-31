package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ca;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXPushJournal.java */
/* loaded from: classes.dex */
public class Oa implements Ca.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0231f f4219a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Oa(C0231f c0231f) {
        this.f4219a = c0231f;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ca.b
    public void a(JSONObject jSONObject) throws AdobeDCXException {
        String optString = jSONObject.optString("composite-href");
        int optInt = jSONObject.optInt("push-journal-format-version");
        if (optInt != 3 && optInt != 4) {
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidJournal, String.format("Format version expected: 3 -- found: %s.", Integer.valueOf(optInt)));
        }
        if (this.f4219a.r() != null && optString != null && !optString.equals(this.f4219a.r().toString())) {
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidJournal, "Composite's and journal's hrefs don't match.");
        }
        if (jSONObject.opt("deleted-components") != null) {
            if (jSONObject.opt("uploaded-components") != null) {
                if (jSONObject.optInt("push-journal-format-version") == 3) {
                    if (jSONObject.opt("etag") != null) {
                        try {
                            jSONObject.put("push-completed", 1);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    try {
                        jSONObject.put("push-journal-format-version", 4);
                        return;
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            }
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidJournal, "No uploaded-components section found.");
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidJournal, "No deleted-components section found.");
    }
}
