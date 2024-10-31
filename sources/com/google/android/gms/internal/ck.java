package com.google.android.gms.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes.dex */
class ck extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebView f1477a;
    final /* synthetic */ cj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar, WebView webView) {
        this.b = cjVar;
        this.f1477a = webView;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Loading assets have finished");
        this.b.c.zzCr.remove(this.f1477a);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        com.google.android.gms.ads.internal.util.client.zzb.e("Loading assets have failed.");
        this.b.c.zzCr.remove(this.f1477a);
    }
}
