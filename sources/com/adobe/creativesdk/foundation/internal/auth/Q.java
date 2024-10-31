package com.adobe.creativesdk.foundation.internal.auth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.HttpAuthHandler;

/* compiled from: AdobeAuthSignInActivity.java */
/* loaded from: classes.dex */
class Q implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AlertDialog f4852a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ HttpAuthHandler f4853b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ T f4854c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(T t, AlertDialog alertDialog, HttpAuthHandler httpAuthHandler) {
        this.f4854c = t;
        this.f4852a = alertDialog;
        this.f4853b = httpAuthHandler;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4854c.f4864f.f4788h = true;
        dialogInterface.cancel();
        this.f4852a.dismiss();
        this.f4853b.cancel();
    }
}
