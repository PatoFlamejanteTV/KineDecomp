package com.nextreaming.nexeditorui;

import android.view.View;
import android.webkit.WebView;

/* compiled from: NexEditorHelp.java */
/* loaded from: classes.dex */
class cf implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorHelp f4569a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(NexEditorHelp nexEditorHelp) {
        this.f4569a = nexEditorHelp;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebView webView;
        WebView webView2;
        webView = this.f4569a.f4484a;
        if (webView.canGoForward()) {
            webView2 = this.f4569a.f4484a;
            webView2.goForward();
        }
    }
}
