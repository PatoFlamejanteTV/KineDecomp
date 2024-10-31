package com.facebook;

import com.facebook.GraphRequest;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONObject;

/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
final class s implements GraphRequest.Callback {

    /* renamed from: a */
    final /* synthetic */ GraphRequest.GraphJSONArrayCallback f335a;

    public s(GraphRequest.GraphJSONArrayCallback graphJSONArrayCallback) {
        this.f335a = graphJSONArrayCallback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        if (this.f335a != null) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            this.f335a.onCompleted(jSONObject != null ? jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA) : null, graphResponse);
        }
    }
}
