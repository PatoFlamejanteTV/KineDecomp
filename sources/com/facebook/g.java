package com.facebook;

import com.facebook.GraphRequest;
import com.facebook.d;
import org.json.JSONObject;

/* compiled from: AccessTokenManager.java */
/* loaded from: classes.dex */
public class g implements GraphRequest.Callback {

    /* renamed from: a */
    final /* synthetic */ d.a f265a;
    final /* synthetic */ d b;

    public g(d dVar, d.a aVar) {
        this.b = dVar;
        this.f265a = aVar;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject != null) {
            this.f265a.f262a = jSONObject.optString("access_token");
            this.f265a.b = jSONObject.optInt("expires_at");
        }
    }
}
