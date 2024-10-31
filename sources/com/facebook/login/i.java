package com.facebook.login;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;

/* compiled from: WebViewLoginMethodHandler.java */
/* loaded from: classes.dex */
class I implements WebDialog.OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LoginClient.Request f9362a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ K f9363b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(K k, LoginClient.Request request) {
        this.f9363b = k;
        this.f9362a = request;
    }

    @Override // com.facebook.internal.WebDialog.OnCompleteListener
    public void onComplete(Bundle bundle, FacebookException facebookException) {
        this.f9363b.a(this.f9362a, bundle, facebookException);
    }
}
