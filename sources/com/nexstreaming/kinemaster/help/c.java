package com.nexstreaming.kinemaster.help;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.GridView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: HelpActivity.java */
/* loaded from: classes.dex */
class c extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HelpActivity f3398a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HelpActivity helpActivity) {
        this.f3398a = helpActivity;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return super.shouldOverrideUrlLoading(webView, str);
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
        z = this.f3398a.c;
        if (z) {
            webView3 = this.f3398a.f3395a;
            webView3.clearHistory();
            this.f3398a.c = false;
        }
        webView2 = this.f3398a.f3395a;
        webView2.postDelayed(new d(this, str, webView), 80L);
        super.onPageFinished(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WebView webView, String str) {
        WebView webView2;
        GridView gridView;
        webView2 = this.f3398a.f3395a;
        webView2.setVisibility(0);
        gridView = this.f3398a.j;
        gridView.setVisibility(8);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        boolean z;
        WebView webView2;
        z = this.f3398a.c;
        if (z) {
            webView2 = this.f3398a.f3395a;
            webView2.clearHistory();
        }
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
        AssetManager assets = this.f3398a.getAssets();
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
            } catch (FileNotFoundException e2) {
                replace2.replace("help/", "help_common/");
                inputStream = null;
            } catch (IOException e3) {
                Log.w("HelpActivity", "not found in common:" + replace2, e);
                inputStream = null;
            }
        } catch (IOException e4) {
            Log.w("HelpActivity", "not found:" + replace, e4);
            inputStream = null;
        }
        if (inputStream != null) {
            return new WebResourceResponse(str2, str3, inputStream);
        }
        return null;
    }
}
