package com.facebook;

import android.util.Log;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccessTokenManager.java */
/* renamed from: com.facebook.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0726e implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f9251a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Set f9252b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Set f9253c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccessTokenManager f9254d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0726e(AccessTokenManager accessTokenManager, AtomicBoolean atomicBoolean, Set set, Set set2) {
        this.f9254d = accessTokenManager;
        this.f9251a = atomicBoolean;
        this.f9252b = set;
        this.f9253c = set2;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        JSONArray optJSONArray;
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA)) == null) {
            return;
        }
        this.f9251a.set(true);
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("permission");
                String optString2 = optJSONObject.optString("status");
                if (!Utility.isNullOrEmpty(optString) && !Utility.isNullOrEmpty(optString2)) {
                    String lowerCase = optString2.toLowerCase(Locale.US);
                    if (lowerCase.equals("granted")) {
                        this.f9252b.add(optString);
                    } else if (lowerCase.equals("declined")) {
                        this.f9253c.add(optString);
                    } else {
                        Log.w(AccessTokenManager.TAG, "Unexpected status: " + lowerCase);
                    }
                }
            }
        }
    }
}
