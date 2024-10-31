package com.facebook.login.widget;

import android.content.DialogInterface;
import com.facebook.login.widget.LoginButton;

/* compiled from: LoginButton.java */
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ LoginButton.b f326a;

    public e(LoginButton.b bVar) {
        this.f326a = bVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        LoginButton.this.getLoginManager().logOut();
    }
}
