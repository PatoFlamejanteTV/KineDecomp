package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.hb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2116hb extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f22928a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Dialog f22929b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22930c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2116hb(ProjectGalleryActivity projectGalleryActivity, int i, Dialog dialog) {
        this.f22930c = projectGalleryActivity;
        this.f22928a = i;
        this.f22929b = dialog;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f22930c.Na = this.f22928a;
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith("market")) {
            this.f22930c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
        if (str.equalsIgnoreCase("km:close")) {
            ProjectGalleryActivity projectGalleryActivity = this.f22930c;
            int i = projectGalleryActivity.Na;
            int i2 = this.f22928a;
            if (i == i2 && i2 >= 0) {
                com.nexstreaming.app.general.tracelog.r.a(projectGalleryActivity, i);
            }
            this.f22929b.dismiss();
            return true;
        }
        webView.loadUrl(str);
        return true;
    }
}
