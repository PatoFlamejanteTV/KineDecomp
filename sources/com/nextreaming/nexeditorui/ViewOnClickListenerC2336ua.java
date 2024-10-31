package com.nextreaming.nexeditorui;

import android.view.View;
import android.webkit.WebView;

/* compiled from: NexEditorHelp.java */
/* renamed from: com.nextreaming.nexeditorui.ua */
/* loaded from: classes.dex */
class ViewOnClickListenerC2336ua implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NexEditorHelp f24401a;

    public ViewOnClickListenerC2336ua(NexEditorHelp nexEditorHelp) {
        this.f24401a = nexEditorHelp;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebView webView;
        WebView webView2;
        webView = this.f24401a.H;
        if (webView.canGoBack()) {
            webView2 = this.f24401a.H;
            webView2.goBack();
        }
    }
}
