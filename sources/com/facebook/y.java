package com.facebook;

import android.net.Uri;
import android.util.Log;
import com.facebook.internal.Utility;
import org.json.JSONObject;

/* compiled from: Profile.java */
/* loaded from: classes.dex */
public class y implements Utility.GraphMeRequestWithCacheCallback {
    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onFailure(FacebookException facebookException) {
        String str;
        str = Profile.TAG;
        Log.e(str, "Got unexpected exception: " + facebookException);
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onSuccess(JSONObject jSONObject) {
        String optString = jSONObject.optString("id");
        if (optString == null) {
            return;
        }
        String optString2 = jSONObject.optString("link");
        Profile.setCurrentProfile(new Profile(optString, jSONObject.optString("first_name"), jSONObject.optString("middle_name"), jSONObject.optString("last_name"), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
    }
}
