package com.nextreaming.nexeditorui;

import android.view.View;
import android.webkit.WebView;

/* compiled from: NexEditorHelp.java */
/* loaded from: classes.dex */
class ce implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorHelp f4568a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(NexEditorHelp nexEditorHelp) {
        this.f4568a = nexEditorHelp;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebView webView;
        WebView webView2;
        webView = this.f4568a.f4484a;
        if (webView.canGoBack()) {
            webView2 = this.f4568a.f4484a;
            webView2.goBack();
        }
    }
}
