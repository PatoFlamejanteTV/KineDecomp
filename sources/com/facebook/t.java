package com.facebook;

import com.facebook.GraphRequest;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
public class t implements GraphRequest.Callback {

    /* renamed from: a */
    final /* synthetic */ GraphRequest.Callback f411a;
    final /* synthetic */ GraphRequest b;

    public t(GraphRequest graphRequest, GraphRequest.Callback callback) {
        this.b = graphRequest;
        this.f411a = callback;
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
        if (this.f411a != null) {
            this.f411a.onCompleted(graphResponse);
        }
    }
}
