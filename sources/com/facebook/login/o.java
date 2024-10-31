package com.facebook.login;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;

/* compiled from: WebViewLoginMethodHandler.java */
/* loaded from: classes.dex */
class o implements WebDialog.OnCompleteListener {

    /* renamed from: a */
    final /* synthetic */ LoginClient.Request f318a;
    final /* synthetic */ WebViewLoginMethodHandler b;

    public o(WebViewLoginMethodHandler webViewLoginMethodHandler, LoginClient.Request request) {
        this.b = webViewLoginMethodHandler;
        this.f318a = request;
    }

    @Override // com.facebook.internal.WebDialog.OnCompleteListener
    public void onComplete(Bundle bundle, FacebookException facebookException) {
        this.b.a(this.f318a, bundle, facebookException);
    }
}
