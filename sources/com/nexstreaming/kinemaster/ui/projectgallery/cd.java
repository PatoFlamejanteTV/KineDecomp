package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class cd extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4184a;
    final /* synthetic */ Dialog b;
    final /* synthetic */ ProjectGalleryActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(ProjectGalleryActivity projectGalleryActivity, int i, Dialog dialog) {
        this.c = projectGalleryActivity;
        this.f4184a = i;
        this.b = dialog;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Activity D;
        if (str.startsWith("market")) {
            this.c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
        if (str.equalsIgnoreCase("km:close")) {
            if (this.c.f4123a == this.f4184a && this.f4184a >= 0) {
                D = this.c.D();
                com.nexstreaming.app.general.tracelog.j.b(D, this.c.f4123a);
            }
            this.b.dismiss();
            return true;
        }
        webView.loadUrl(str);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.c.f4123a = this.f4184a;
        super.onPageFinished(webView, str);
    }
}
