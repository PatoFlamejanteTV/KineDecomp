package com.nextreaming.nexeditorui;

import android.webkit.WebView;

/* compiled from: NexEditorHelp.java */
/* renamed from: com.nextreaming.nexeditorui.sa */
/* loaded from: classes.dex */
class RunnableC2332sa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebView f24395a;

    /* renamed from: b */
    final /* synthetic */ String f24396b;

    /* renamed from: c */
    final /* synthetic */ C2334ta f24397c;

    public RunnableC2332sa(C2334ta c2334ta, WebView webView, String str) {
        this.f24397c = c2334ta;
        this.f24395a = webView;
        this.f24396b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f24397c.a(this.f24395a, this.f24396b);
    }
}
