package com.facebook;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AccessToken.java */
/* loaded from: classes.dex */
final class a implements Utility.GraphMeRequestWithCacheCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f238a;
    final /* synthetic */ AccessToken.AccessTokenCreationCallback b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Bundle bundle, AccessToken.AccessTokenCreationCallback accessTokenCreationCallback, String str) {
        this.f238a = bundle;
        this.b = accessTokenCreationCallback;
        this.c = str;
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onSuccess(JSONObject jSONObject) {
        AccessToken createFromBundle;
        try {
            this.f238a.putString(AccessToken.USER_ID_KEY, jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_ID));
            AccessToken.AccessTokenCreationCallback accessTokenCreationCallback = this.b;
            createFromBundle = AccessToken.createFromBundle(null, this.f238a, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), this.c);
            accessTokenCreationCallback.onSuccess(createFromBundle);
        } catch (JSONException e) {
            this.b.onError(new FacebookException("Unable to generate access token due to missing user id"));
        }
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onFailure(FacebookException facebookException) {
        this.b.onError(facebookException);
    }
}
