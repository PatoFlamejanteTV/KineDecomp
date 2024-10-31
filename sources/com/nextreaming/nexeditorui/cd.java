package com.nextreaming.nexeditorui;

import android.webkit.WebView;

/* compiled from: NexEditorHelp.java */
/* loaded from: classes.dex */
class cd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebView f4567a;
    final /* synthetic */ String b;
    final /* synthetic */ ca c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(ca caVar, WebView webView, String str) {
        this.c = caVar;
        this.f4567a = webView;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.f4567a, this.b);
    }
}
