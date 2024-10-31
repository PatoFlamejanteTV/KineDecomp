package com.adobe.creativesdk.foundation.internal.auth;

import android.content.DialogInterface;
import android.webkit.HttpAuthHandler;
import android.widget.EditText;

/* compiled from: AdobeAuthSignInActivity.java */
/* loaded from: classes.dex */
class S implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HttpAuthHandler f4855a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ EditText f4856b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ EditText f4857c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ T f4858d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(T t, HttpAuthHandler httpAuthHandler, EditText editText, EditText editText2) {
        this.f4858d = t;
        this.f4855a = httpAuthHandler;
        this.f4856b = editText;
        this.f4857c = editText2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4858d.f4864f.f4788h = true;
        this.f4855a.proceed(this.f4856b.getText().toString(), this.f4857c.getText().toString());
    }
}
