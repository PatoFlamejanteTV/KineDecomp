package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

@zzgr
/* loaded from: classes.dex */
public class zzji extends WebViewClient {
    private final zzgd zzDt;
    private final String zzKH;
    private boolean zzKI = false;
    private final zziz zzoM;

    public zzji(zzgd zzgdVar, zziz zzizVar, String str) {
        this.zzKH = zzaO(str);
        this.zzoM = zzizVar;
        this.zzDt = zzgdVar;
    }

    private String zzaO(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.endsWith("/") ? str.substring(0, str.length() - 1) : str;
        } catch (IndexOutOfBoundsException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b(e.getMessage());
            return str;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.client.zzb.a("JavascriptAdWebViewClient::onLoadResource: " + str);
        if (zzaN(str)) {
            return;
        }
        this.zzoM.zzhe().onLoadResource(this.zzoM.getWebView(), str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.client.zzb.a("JavascriptAdWebViewClient::onPageFinished: " + str);
        if (this.zzKI) {
            return;
        }
        this.zzDt.zzfv();
        this.zzKI = true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.client.zzb.a("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + str);
        if (!zzaN(str)) {
            return this.zzoM.zzhe().shouldOverrideUrlLoading(this.zzoM.getWebView(), str);
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("shouldOverrideUrlLoading: received passback url");
        return true;
    }

    protected boolean zzaN(String str) {
        boolean z = false;
        String zzaO = zzaO(str);
        if (!TextUtils.isEmpty(zzaO)) {
            try {
                URI uri = new URI(zzaO);
                if ("passback".equals(uri.getScheme())) {
                    com.google.android.gms.ads.internal.util.client.zzb.a("Passback received");
                    this.zzDt.zzfw();
                    z = true;
                } else if (!TextUtils.isEmpty(this.zzKH)) {
                    URI uri2 = new URI(this.zzKH);
                    String host = uri2.getHost();
                    String host2 = uri.getHost();
                    String path = uri2.getPath();
                    String path2 = uri.getPath();
                    if (com.google.android.gms.common.internal.zzw.a(host, host2) && com.google.android.gms.common.internal.zzw.a(path, path2)) {
                        com.google.android.gms.ads.internal.util.client.zzb.a("Passback received");
                        this.zzDt.zzfw();
                        z = true;
                    }
                }
            } catch (URISyntaxException e) {
                com.google.android.gms.ads.internal.util.client.zzb.b(e.getMessage());
            }
        }
        return z;
    }
}
