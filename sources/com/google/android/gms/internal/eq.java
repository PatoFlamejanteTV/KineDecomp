package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* loaded from: classes.dex */
final class eq implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JsPromptResult f1536a;
    final /* synthetic */ EditText b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(JsPromptResult jsPromptResult, EditText editText) {
        this.f1536a = jsPromptResult;
        this.b = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1536a.confirm(this.b.getText().toString());
    }
}
