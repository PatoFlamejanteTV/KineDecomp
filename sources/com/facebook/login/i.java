package com.facebook.login;

import com.facebook.login.LoginClient;

/* compiled from: LoginFragment.java */
/* loaded from: classes.dex */
class i implements LoginClient.OnCompletedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LoginFragment f313a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LoginFragment loginFragment) {
        this.f313a = loginFragment;
    }

    @Override // com.facebook.login.LoginClient.OnCompletedListener
    public void onCompleted(LoginClient.Result result) {
        this.f313a.onLoginClientCompleted(result);
    }
}
