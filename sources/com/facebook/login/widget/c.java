package com.facebook.login.widget;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;

/* compiled from: LoginButton.java */
/* loaded from: classes.dex */
class c extends AccessTokenTracker {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LoginButton f324a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LoginButton loginButton) {
        this.f324a = loginButton;
    }

    @Override // com.facebook.AccessTokenTracker
    protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
        this.f324a.setButtonText();
    }
}
