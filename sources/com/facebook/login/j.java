package com.facebook.login;

import android.view.View;
import com.facebook.R;
import com.facebook.login.LoginClient;

/* compiled from: LoginFragment.java */
/* loaded from: classes.dex */
class j implements LoginClient.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f314a;
    final /* synthetic */ LoginFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LoginFragment loginFragment, View view) {
        this.b = loginFragment;
        this.f314a = view;
    }

    @Override // com.facebook.login.LoginClient.a
    public void a() {
        this.f314a.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(0);
    }

    @Override // com.facebook.login.LoginClient.a
    public void b() {
        this.f314a.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
    }
}
