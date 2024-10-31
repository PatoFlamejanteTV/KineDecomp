package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* loaded from: classes.dex */
final class en implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JsResult f1533a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(JsResult jsResult) {
        this.f1533a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1533a.confirm();
    }
}
