package com.facebook;

import android.net.Uri;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Profile.java */
/* loaded from: classes.dex */
public final class z implements Utility.GraphMeRequestWithCacheCallback {
    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onSuccess(JSONObject jSONObject) {
        String optString = jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
        if (optString != null) {
            String optString2 = jSONObject.optString("link");
            Profile.setCurrentProfile(new Profile(optString, jSONObject.optString("first_name"), jSONObject.optString("middle_name"), jSONObject.optString("last_name"), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
        }
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onFailure(FacebookException facebookException) {
    }
}
