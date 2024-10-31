package com.nextreaming.nexeditorui;

import android.view.View;
import android.webkit.WebView;

/* compiled from: NexEditorHelp.java */
/* renamed from: com.nextreaming.nexeditorui.va */
/* loaded from: classes.dex */
class ViewOnClickListenerC2338va implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NexEditorHelp f24403a;

    public ViewOnClickListenerC2338va(NexEditorHelp nexEditorHelp) {
        this.f24403a = nexEditorHelp;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebView webView;
        WebView webView2;
        webView = this.f24403a.H;
        if (webView.canGoForward()) {
            webView2 = this.f24403a.H;
            webView2.goForward();
        }
    }
}
