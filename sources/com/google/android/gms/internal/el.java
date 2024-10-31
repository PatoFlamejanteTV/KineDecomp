package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* loaded from: classes.dex */
final class el implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JsResult f1531a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(JsResult jsResult) {
        this.f1531a = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f1531a.cancel();
    }
}
