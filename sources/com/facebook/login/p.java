package com.facebook.login;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetTokenLoginMethodHandler.java */
/* loaded from: classes.dex */
class p implements Utility.GraphMeRequestWithCacheCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f9393a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LoginClient.Request f9394b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0753r f9395c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(C0753r c0753r, Bundle bundle, LoginClient.Request request) {
        this.f9395c = c0753r;
        this.f9393a = bundle;
        this.f9394b = request;
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onFailure(FacebookException facebookException) {
        LoginClient loginClient = this.f9395c.loginClient;
        loginClient.a(LoginClient.Result.createErrorResult(loginClient.i(), "Caught exception", facebookException.getMessage()));
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onSuccess(JSONObject jSONObject) {
        try {
            this.f9393a.putString(NativeProtocol.EXTRA_USER_ID, jSONObject.getString("id"));
            this.f9395c.c(this.f9394b, this.f9393a);
        } catch (JSONException e2) {
            LoginClient loginClient = this.f9395c.loginClient;
            loginClient.a(LoginClient.Result.createErrorResult(loginClient.i(), "Caught exception", e2.getMessage()));
        }
    }
}
