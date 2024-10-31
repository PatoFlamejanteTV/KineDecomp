package com.facebook;

import com.facebook.GraphRequest;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONObject;

/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
final class q implements GraphRequest.Callback {

    /* renamed from: a */
    final /* synthetic */ GraphRequest.GraphJSONArrayCallback f334a;

    public q(GraphRequest.GraphJSONArrayCallback graphJSONArrayCallback) {
        this.f334a = graphJSONArrayCallback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        if (this.f334a != null) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            this.f334a.onCompleted(jSONObject != null ? jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA) : null, graphResponse);
        }
    }
}
