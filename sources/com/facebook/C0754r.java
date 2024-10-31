package com.facebook;

import com.facebook.GraphRequest;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONObject;

/* compiled from: GraphRequest.java */
/* renamed from: com.facebook.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0754r implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GraphRequest.GraphJSONArrayCallback f9467a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0754r(GraphRequest.GraphJSONArrayCallback graphJSONArrayCallback) {
        this.f9467a = graphJSONArrayCallback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        if (this.f9467a != null) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            this.f9467a.onCompleted(jSONObject != null ? jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA) : null, graphResponse);
        }
    }
}
