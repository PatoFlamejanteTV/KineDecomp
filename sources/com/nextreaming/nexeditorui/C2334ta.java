package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: NexEditorHelp.java */
/* renamed from: com.nextreaming.nexeditorui.ta */
/* loaded from: classes.dex */
public class C2334ta extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ NexEditorHelp f24399a;

    public C2334ta(NexEditorHelp nexEditorHelp) {
        this.f24399a = nexEditorHelp;
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
        z = this.f24399a.K;
        if (z) {
            webView3 = this.f24399a.H;
            webView3.clearHistory();
            this.f24399a.K = false;
        }
        webView2 = this.f24399a.H;
        webView2.postDelayed(new RunnableC2332sa(this, webView, str), 5L);
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        boolean z;
        View view;
        View view2;
        WebView webView2;
        z = this.f24399a.K;
        if (z) {
            webView2 = this.f24399a.H;
            webView2.clearHistory();
        }
        view = this.f24399a.I;
        view.setEnabled(webView.canGoBack());
        view2 = this.f24399a.J;
        view2.setEnabled(webView.canGoForward());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c8  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r8 = "NexEditorHelp"
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
            com.nextreaming.nexeditorui.NexEditorHelp r2 = r7.f24399a
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
            goto Lc5
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
            goto Lc5
        La4:
            r5 = move-exception
            java.lang.String r6 = "help_common/"
            java.lang.String r9 = r9.replace(r0, r6)
            java.io.InputStream r8 = r2.open(r9)     // Catch: java.io.IOException -> Lb0
            goto Lc5
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
            if (r8 != 0) goto Lc8
            return r1
        Lc8:
            android.webkit.WebResourceResponse r9 = new android.webkit.WebResourceResponse
            r9.<init>(r3, r4, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.C2334ta.shouldInterceptRequest(android.webkit.WebView, java.lang.String):android.webkit.WebResourceResponse");
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebView webView2;
        WebView webView3;
        if (!str.startsWith("nexeditor:") && !str.startsWith("km:")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        if (str.equals("km:license")) {
            webView3 = this.f24399a.H;
            webView3.post(new RunnableC2329qa(this));
            return true;
        }
        if (str.equals("km:privacy")) {
            webView2 = this.f24399a.H;
            webView2.post(new RunnableC2330ra(this));
            return true;
        }
        str.equals("nexeditor:guide_reset");
        return true;
    }

    /* JADX WARN: Incorrect condition in loop: B:19:0x005a */
    /* JADX WARN: Incorrect condition in loop: B:34:0x00a8 */
    /* JADX WARN: Incorrect condition in loop: B:3:0x0026 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.webkit.WebView r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.C2334ta.a(android.webkit.WebView, java.lang.String):void");
    }
}
