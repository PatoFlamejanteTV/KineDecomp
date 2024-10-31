package com.facebook.login;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GetTokenLoginMethodHandler.java */
/* loaded from: classes.dex */
public class c implements Utility.GraphMeRequestWithCacheCallback {

    /* renamed from: a */
    final /* synthetic */ Bundle f312a;
    final /* synthetic */ LoginClient.Request b;
    final /* synthetic */ GetTokenLoginMethodHandler c;

    public c(GetTokenLoginMethodHandler getTokenLoginMethodHandler, Bundle bundle, LoginClient.Request request) {
        this.c = getTokenLoginMethodHandler;
        this.f312a = bundle;
        this.b = request;
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onSuccess(JSONObject jSONObject) {
        try {
            this.f312a.putString(NativeProtocol.EXTRA_USER_ID, jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_ID));
            this.c.b(this.b, this.f312a);
        } catch (JSONException e) {
            this.c.b.b(LoginClient.Result.createErrorResult(this.c.b.c(), "Caught exception", e.getMessage()));
        }
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onFailure(FacebookException facebookException) {
        this.c.b.b(LoginClient.Result.createErrorResult(this.c.b.c(), "Caught exception", facebookException.getMessage()));
    }
}
