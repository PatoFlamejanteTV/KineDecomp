package com.nextreaming.nexeditorui;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditorHelp.java */
/* loaded from: classes.dex */
public class ca extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorHelp f4564a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(NexEditorHelp nexEditorHelp) {
        this.f4564a = nexEditorHelp;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebView webView2;
        WebView webView3;
        if (str.startsWith("nexeditor:") || str.startsWith("km:")) {
            if (str.equals("km:license")) {
                webView3 = this.f4564a.f4484a;
                webView3.post(new cb(this));
            } else if (str.equals("km:privacy")) {
                webView2 = this.f4564a.f4484a;
                webView2.post(new cc(this));
            } else if (str.equals("nexeditor:guide_reset")) {
            }
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        String str2;
        String str3;
        InputStream inputStream;
        if (str.startsWith("http")) {
            return new WebResourceResponse("", "", null);
        }
        String replaceAll = str.replaceAll("file:///android_asset/help[^/]*/", "help/");
        AssetManager assets = this.f4564a.getAssets();
        if (replaceAll.endsWith(".jpg") || replaceAll.endsWith(".jpeg") || replaceAll.endsWith(".png") || replaceAll.endsWith(".webp")) {
            str2 = "image/*";
            str3 = "base64";
        } else if (replaceAll.endsWith(".htm") || replaceAll.endsWith(".html")) {
            str2 = "text/html";
            str3 = "utf-8";
        } else if (replaceAll.endsWith(".css")) {
            str2 = "text/css";
            str3 = "utf-8";
        } else if (replaceAll.endsWith(".js")) {
            str2 = "text/javascript";
            str3 = "utf-8";
        } else if (replaceAll.endsWith(".svg")) {
            str2 = "image/svg+xml";
            str3 = "utf-8";
        } else {
            str3 = null;
            str2 = null;
        }
        String replace = replaceAll.replace("%20", " ");
        try {
            inputStream = assets.open(replace);
        } catch (FileNotFoundException e) {
            String replace2 = replace.replace("help/", "help_common/");
            try {
                inputStream = assets.open(replace2);
            } catch (IOException e2) {
                Log.w("NexEditorHelp", "not found in common:" + replace2, e);
                inputStream = null;
            }
        } catch (IOException e3) {
            Log.w("NexEditorHelp", "not found:" + replace, e3);
            inputStream = null;
        }
        if (inputStream != null) {
            return new WebResourceResponse(str2, str3, inputStream);
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        boolean z;
        WebView webView2;
        WebView webView3;
        z = this.f4564a.e;
        if (z) {
            webView3 = this.f4564a.f4484a;
            webView3.clearHistory();
            this.f4564a.e = false;
        }
        webView2 = this.f4564a.f4484a;
        webView2.postDelayed(new cd(this, webView, str), 5L);
        super.onPageFinished(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Incorrect condition in loop: B:18:0x0058 */
    /* JADX WARN: Incorrect condition in loop: B:33:0x00a5 */
    /* JADX WARN: Incorrect condition in loop: B:3:0x0028 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.webkit.WebView r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.ca.a(android.webkit.WebView, java.lang.String):void");
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        boolean z;
        View view;
        View view2;
        WebView webView2;
        z = this.f4564a.e;
        if (z) {
            webView2 = this.f4564a.f4484a;
            webView2.clearHistory();
        }
        view = this.f4564a.b;
        view.setEnabled(webView.canGoBack());
        view2 = this.f4564a.c;
        view2.setEnabled(webView.canGoForward());
    }
}
