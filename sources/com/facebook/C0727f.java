package com.facebook;

import com.facebook.AccessTokenManager;
import com.facebook.GraphRequest;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccessTokenManager.java */
/* renamed from: com.facebook.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0727f implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccessTokenManager.a f9255a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AccessTokenManager f9256b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0727f(AccessTokenManager accessTokenManager, AccessTokenManager.a aVar) {
        this.f9256b = accessTokenManager;
        this.f9255a = aVar;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject == null) {
            return;
        }
        this.f9255a.f9115a = jSONObject.optString("access_token");
        this.f9255a.f9116b = jSONObject.optInt("expires_at");
    }
}
