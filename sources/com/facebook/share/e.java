package com.facebook.share;

import com.facebook.FacebookCallback;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.share.internal.ShareInternalUtility;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class e implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f9481a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ShareApi f9482b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ShareApi shareApi, FacebookCallback facebookCallback) {
        this.f9482b = shareApi;
        this.f9481a = facebookCallback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        JSONObject jSONObject = graphResponse.getJSONObject();
        ShareInternalUtility.invokeCallbackWithResults(this.f9481a, jSONObject == null ? null : jSONObject.optString("id"), graphResponse);
    }
}
