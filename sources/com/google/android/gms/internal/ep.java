package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* loaded from: classes.dex */
final class ep implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JsPromptResult f1535a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ep(JsPromptResult jsPromptResult) {
        this.f1535a = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1535a.cancel();
    }
}
