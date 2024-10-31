package com.adobe.creativesdk.foundation.internal.auth;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthContinuableEventActivity;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeAuthContinuableEventActivity.java */
/* loaded from: classes.dex */
class U extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    AdobeAuthContinuableEventActivity.a f4867a;

    public U(AdobeAuthContinuableEventActivity.a aVar) {
        this.f4867a = aVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AdobeAuthContinuableActivity", "onPageFinished:Webpage =" + str);
        this.f4867a.A();
    }
}
