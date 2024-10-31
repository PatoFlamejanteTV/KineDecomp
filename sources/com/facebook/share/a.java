package com.facebook.share;

import com.facebook.FacebookCallback;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class a implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f336a;
    final /* synthetic */ ShareApi b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ShareApi shareApi, FacebookCallback facebookCallback) {
        this.b = shareApi;
        this.f336a = facebookCallback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        JSONObject jSONObject = graphResponse.getJSONObject();
        ShareInternalUtility.invokeCallbackWithResults(this.f336a, jSONObject == null ? null : jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID), graphResponse);
    }
}
