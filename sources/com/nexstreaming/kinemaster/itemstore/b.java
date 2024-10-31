package com.nexstreaming.kinemaster.itemstore;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import java.util.Map;

/* compiled from: KMAssetStore.java */
/* loaded from: classes.dex */
class b extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ KMAssetStore f3409a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(KMAssetStore kMAssetStore) {
        this.f3409a = kMAssetStore;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Map<String, String> c;
        c = this.f3409a.c();
        webView.loadUrl(str, c);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Toolbar toolbar;
        Toolbar toolbar2;
        Toolbar toolbar3;
        Toolbar toolbar4;
        Toolbar toolbar5;
        Toolbar toolbar6;
        Toolbar toolbar7;
        Toolbar toolbar8;
        Toolbar toolbar9;
        Toolbar toolbar10;
        ProgressBar progressBar;
        Toolbar toolbar11;
        Toolbar toolbar12;
        webView.invalidate();
        if (str.contains("zoom")) {
            toolbar11 = this.f3409a.f3405a;
            if (toolbar11 != null) {
                toolbar12 = this.f3409a.f3405a;
                toolbar12.setVisibility(8);
            }
        } else if (str.contains("view")) {
            toolbar6 = this.f3409a.f3405a;
            if (toolbar6 != null) {
                toolbar7 = this.f3409a.f3405a;
                toolbar7.setVisibility(0);
                toolbar8 = this.f3409a.f3405a;
                toolbar8.setTitleMode(Toolbar.TitleMode.Back);
                toolbar9 = this.f3409a.f3405a;
                toolbar9.setTitle(webView.getTitle());
                toolbar10 = this.f3409a.f3405a;
                toolbar10.setLogoVisiblity(false);
            }
        } else {
            toolbar = this.f3409a.f3405a;
            if (toolbar != null) {
                toolbar2 = this.f3409a.f3405a;
                toolbar2.setVisibility(0);
                toolbar3 = this.f3409a.f3405a;
                toolbar3.setTitleMode(Toolbar.TitleMode.Title);
                toolbar4 = this.f3409a.f3405a;
                toolbar4.setTitle("");
                toolbar5 = this.f3409a.f3405a;
                toolbar5.setLogoVisiblity(true);
                this.f3409a.e = null;
            }
        }
        progressBar = this.f3409a.c;
        progressBar.setVisibility(4);
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ProgressBar progressBar;
        progressBar = this.f3409a.c;
        progressBar.setVisibility(0);
    }
}
