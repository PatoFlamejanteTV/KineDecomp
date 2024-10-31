package com.facebook;

import com.facebook.GraphRequest;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONObject;

/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
class s implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GraphRequest.GraphJSONArrayCallback f9468a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(GraphRequest.GraphJSONArrayCallback graphJSONArrayCallback) {
        this.f9468a = graphJSONArrayCallback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        if (this.f9468a != null) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            this.f9468a.onCompleted(jSONObject != null ? jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA) : null, graphResponse);
        }
    }
}
