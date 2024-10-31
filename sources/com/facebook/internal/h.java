package com.facebook.internal;

import android.content.Context;
import android.webkit.WebView;

/* compiled from: WebDialog.java */
/* loaded from: classes.dex */
public class H extends WebView {

    /* renamed from: a */
    final /* synthetic */ WebDialog f9285a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(WebDialog webDialog, Context context) {
        super(context);
        this.f9285a = webDialog;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
        } catch (NullPointerException unused) {
        }
    }
}
