package com.facebook;

import com.facebook.GraphRequest;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
public class t implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GraphRequest.Callback f9661a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ GraphRequest f9662b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(GraphRequest graphRequest, GraphRequest.Callback callback) {
        this.f9662b = graphRequest;
        this.f9661a = callback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        JSONObject jSONObject = graphResponse.getJSONObject();
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("__debug__") : null;
        JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("messages") : null;
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                String optString = optJSONObject2 != null ? optJSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE) : null;
                String optString2 = optJSONObject2 != null ? optJSONObject2.optString("type") : null;
                String optString3 = optJSONObject2 != null ? optJSONObject2.optString("link") : null;
                if (optString != null && optString2 != null) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                    if (optString2.equals("warning")) {
                        loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                    }
                    if (!Utility.isNullOrEmpty(optString3)) {
                        optString = optString + " Link: " + optString3;
                    }
                    Logger.log(loggingBehavior, GraphRequest.TAG, optString);
                }
            }
        }
        GraphRequest.Callback callback = this.f9661a;
        if (callback != null) {
            callback.onCompleted(graphResponse);
        }
    }
}
