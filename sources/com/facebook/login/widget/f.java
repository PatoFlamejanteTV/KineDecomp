package com.facebook.login.widget;

import android.content.DialogInterface;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

/* compiled from: LoginButton.java */
/* loaded from: classes.dex */
class f implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LoginManager f9413a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LoginButton.LoginClickListener f9414b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LoginButton.LoginClickListener loginClickListener, LoginManager loginManager) {
        this.f9414b = loginClickListener;
        this.f9413a = loginManager;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f9413a.logOut();
    }
}
