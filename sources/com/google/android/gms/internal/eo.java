package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* loaded from: classes.dex */
final class eo implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JsPromptResult f1534a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(JsPromptResult jsPromptResult) {
        this.f1534a = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f1534a.cancel();
    }
}
