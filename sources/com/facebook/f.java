package com.facebook;

import android.util.Log;
import com.facebook.GraphRequest;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AccessTokenManager.java */
/* loaded from: classes.dex */
public class f implements GraphRequest.Callback {

    /* renamed from: a */
    final /* synthetic */ AtomicBoolean f264a;
    final /* synthetic */ Set b;
    final /* synthetic */ Set c;
    final /* synthetic */ d d;

    public f(d dVar, AtomicBoolean atomicBoolean, Set set, Set set2) {
        this.d = dVar;
        this.f264a = atomicBoolean;
        this.b = set;
        this.c = set2;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        JSONArray optJSONArray;
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA)) != null) {
            this.f264a.set(true);
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("permission");
                    String optString2 = optJSONObject.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
                    if (!Utility.isNullOrEmpty(optString) && !Utility.isNullOrEmpty(optString2)) {
                        String lowerCase = optString2.toLowerCase(Locale.US);
                        if (lowerCase.equals("granted")) {
                            this.b.add(optString);
                        } else if (lowerCase.equals("declined")) {
                            this.c.add(optString);
                        } else {
                            Log.w("AccessTokenManager", "Unexpected status: " + lowerCase);
                        }
                    }
                }
            }
        }
    }
}
