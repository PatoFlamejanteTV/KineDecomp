package com.facebook.login;

import com.facebook.login.LoginClient;

/* compiled from: LoginFragment.java */
/* loaded from: classes.dex */
class x implements LoginClient.OnCompletedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LoginFragment f9419a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LoginFragment loginFragment) {
        this.f9419a = loginFragment;
    }

    @Override // com.facebook.login.LoginClient.OnCompletedListener
    public void onCompleted(LoginClient.Result result) {
        this.f9419a.onLoginClientCompleted(result);
    }
}
