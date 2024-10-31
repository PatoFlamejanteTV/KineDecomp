package com.facebook;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.internal.Utility;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AccessToken.java */
/* renamed from: com.facebook.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0721a implements Utility.GraphMeRequestWithCacheCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f9151a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AccessToken.AccessTokenCreationCallback f9152b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f9153c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0721a(Bundle bundle, AccessToken.AccessTokenCreationCallback accessTokenCreationCallback, String str) {
        this.f9151a = bundle;
        this.f9152b = accessTokenCreationCallback;
        this.f9153c = str;
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onFailure(FacebookException facebookException) {
        this.f9152b.onError(facebookException);
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onSuccess(JSONObject jSONObject) {
        AccessToken createFromBundle;
        try {
            this.f9151a.putString(AccessToken.USER_ID_KEY, jSONObject.getString("id"));
            AccessToken.AccessTokenCreationCallback accessTokenCreationCallback = this.f9152b;
            createFromBundle = AccessToken.createFromBundle(null, this.f9151a, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), this.f9153c);
            accessTokenCreationCallback.onSuccess(createFromBundle);
        } catch (JSONException unused) {
            this.f9152b.onError(new FacebookException("Unable to generate access token due to missing user id"));
        }
    }
}
