package com.facebook.login.widget;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;

/* compiled from: LoginButton.java */
/* loaded from: classes.dex */
class d extends AccessTokenTracker {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LoginButton f9411a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LoginButton loginButton) {
        this.f9411a = loginButton;
    }

    @Override // com.facebook.AccessTokenTracker
    protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
        this.f9411a.setButtonText();
    }
}
