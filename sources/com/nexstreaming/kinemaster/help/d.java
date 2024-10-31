package com.nexstreaming.kinemaster.help;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.GridView;

/* compiled from: HelpActivity.java */
/* loaded from: classes.dex */
class d extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ HelpActivity f20406a;

    public d(HelpActivity helpActivity) {
        this.f20406a = helpActivity;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        WebView webView2;
        WebView webView3;
        z = this.f20406a.J;
        if (z) {
            webView3 = this.f20406a.H;
            webView3.clearHistory();
            this.f20406a.J = false;
        }
        webView2 = this.f20406a.H;
        webView2.postDelayed(new c(this, str, webView), 80L);
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        boolean z;
        WebView webView2;
        z = this.f20406a.J;
        if (z) {
            webView2 = this.f20406a.H;
            webView2.clearHistory();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r8 = "HelpActivity"
            java.lang.String r0 = "http"
            boolean r0 = r9.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L13
            android.webkit.WebResourceResponse r8 = new android.webkit.WebResourceResponse
            java.lang.String r9 = ""
            r8.<init>(r9, r9, r1)
            return r8
        L13:
            java.lang.String r0 = "help/"
        */
        //  java.lang.String r2 = "file:///android_asset/help[^/]*/"
        /*
            java.lang.String r9 = r9.replaceAll(r2, r0)
            com.nexstreaming.kinemaster.help.HelpActivity r2 = r7.f20406a
            android.content.res.AssetManager r2 = r2.getAssets()
            java.lang.String r3 = ".jpg"
            boolean r3 = r9.endsWith(r3)
            java.lang.String r4 = "utf-8"
            if (r3 != 0) goto L7c
            java.lang.String r3 = ".jpeg"
            boolean r3 = r9.endsWith(r3)
            if (r3 != 0) goto L7c
            java.lang.String r3 = ".png"
            boolean r3 = r9.endsWith(r3)
            if (r3 != 0) goto L7c
            java.lang.String r3 = ".webp"
            boolean r3 = r9.endsWith(r3)
            if (r3 == 0) goto L44
            goto L7c
        L44:
            java.lang.String r3 = ".htm"
            boolean r3 = r9.endsWith(r3)
            if (r3 != 0) goto L79
            java.lang.String r3 = ".html"
            boolean r3 = r9.endsWith(r3)
            if (r3 == 0) goto L55
            goto L79
        L55:
            java.lang.String r3 = ".css"
            boolean r3 = r9.endsWith(r3)
            if (r3 == 0) goto L60
            java.lang.String r3 = "text/css"
            goto L80
        L60:
            java.lang.String r3 = ".js"
            boolean r3 = r9.endsWith(r3)
            if (r3 == 0) goto L6b
            java.lang.String r3 = "text/javascript"
            goto L80
        L6b:
            java.lang.String r3 = ".svg"
            boolean r3 = r9.endsWith(r3)
            if (r3 == 0) goto L76
            java.lang.String r3 = "image/svg+xml"
            goto L80
        L76:
            r3 = r1
            r4 = r3
            goto L80
        L79:
            java.lang.String r3 = "text/html"
            goto L80
        L7c:
            java.lang.String r3 = "image/*"
            java.lang.String r4 = "base64"
        L80:
            java.lang.String r5 = "%20"
            java.lang.String r6 = " "
            java.lang.String r9 = r9.replace(r5, r6)
            java.io.InputStream r8 = r2.open(r9)     // Catch: java.io.IOException -> L8d java.io.FileNotFoundException -> La4
            goto Lc9
        L8d:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "not found:"
            r2.append(r5)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            android.util.Log.w(r8, r9, r0)
        La2:
            r8 = r1
            goto Lc9
        La4:
            r5 = move-exception
            java.lang.String r6 = "help_common/"
            java.lang.String r9 = r9.replace(r0, r6)
            java.io.InputStream r8 = r2.open(r9)     // Catch: java.io.IOException -> Lb0 java.io.FileNotFoundException -> Lc5
            goto Lc9
        Lb0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "not found in common:"
            r0.append(r2)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            android.util.Log.w(r8, r9, r5)
            goto La2
        Lc5:
            r9.replace(r0, r6)
            goto La2
        Lc9:
            if (r8 != 0) goto Lcc
            return r1
        Lcc:
            android.webkit.WebResourceResponse r9 = new android.webkit.WebResourceResponse
            r9.<init>(r3, r4, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.help.d.shouldInterceptRequest(android.webkit.WebView, java.lang.String):android.webkit.WebResourceResponse");
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void a(WebView webView, String str) {
        WebView webView2;
        GridView gridView;
        webView2 = this.f20406a.H;
        webView2.setVisibility(0);
        gridView = this.f20406a.P;
        gridView.setVisibility(8);
    }
}
