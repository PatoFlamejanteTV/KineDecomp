package com.google.android.gms.internal;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* loaded from: classes.dex */
class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    ValueCallback<String> f1666a = new x(this);
    final /* synthetic */ zzbh b;
    final /* synthetic */ WebView c;
    final /* synthetic */ zzbk d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(zzbk zzbkVar, zzbh zzbhVar, WebView webView) {
        this.d = zzbkVar;
        this.b = zzbhVar;
        this.c = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.getSettings().getJavaScriptEnabled()) {
            try {
                this.c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.f1666a);
            } catch (Throwable th) {
                this.f1666a.onReceiveValue("");
            }
        }
    }
}
