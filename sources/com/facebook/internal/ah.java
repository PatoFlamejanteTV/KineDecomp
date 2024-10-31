package com.facebook.internal;

import android.content.Context;
import android.webkit.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebDialog.java */
/* loaded from: classes.dex */
public class ah extends WebView {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebDialog f286a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(WebDialog webDialog, Context context) {
        super(context);
        this.f286a = webDialog;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
        } catch (NullPointerException e) {
        }
    }
}
