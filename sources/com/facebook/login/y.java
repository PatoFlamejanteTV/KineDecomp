package com.facebook.login;

import android.view.View;
import com.facebook.login.LoginClient;

/* compiled from: LoginFragment.java */
/* loaded from: classes.dex */
class y implements LoginClient.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f9420a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LoginFragment f9421b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(LoginFragment loginFragment, View view) {
        this.f9421b = loginFragment;
        this.f9420a = view;
    }

    @Override // com.facebook.login.LoginClient.a
    public void a() {
        this.f9420a.setVisibility(0);
    }

    @Override // com.facebook.login.LoginClient.a
    public void b() {
        this.f9420a.setVisibility(8);
    }
}
