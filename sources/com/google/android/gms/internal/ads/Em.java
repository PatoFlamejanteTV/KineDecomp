package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* loaded from: classes2.dex */
final class Em implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private ValueCallback<String> f11515a = new Gm(this);

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzsr f11516b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebView f11517c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f11518d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzsx f11519e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Em(zzsx zzsxVar, zzsr zzsrVar, WebView webView, boolean z) {
        this.f11519e = zzsxVar;
        this.f11516b = zzsrVar;
        this.f11517c = webView;
        this.f11518d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11517c.getSettings().getJavaScriptEnabled()) {
            try {
                this.f11517c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.f11515a);
            } catch (Throwable unused) {
                this.f11515a.onReceiveValue("");
            }
        }
    }
}
