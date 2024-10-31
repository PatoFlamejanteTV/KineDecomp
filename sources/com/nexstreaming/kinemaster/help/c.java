package com.nexstreaming.kinemaster.help;

import android.util.Log;
import android.webkit.WebView;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* compiled from: HelpActivity.java */
/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f20403a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebView f20404b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f20405c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, String str, WebView webView) {
        this.f20405c = dVar;
        this.f20403a = str;
        this.f20404b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        WebView webView;
        g gVar;
        g gVar2;
        Toolbar toolbar;
        f fVar2;
        WebView webView2;
        String title;
        f fVar3;
        Toolbar toolbar2;
        f fVar4;
        WebView webView3;
        String title2;
        f fVar5;
        StringBuilder sb = new StringBuilder();
        sb.append("TESTTEST :: onPageFinished :: ");
        sb.append(this.f20403a);
        sb.append(" :: ");
        fVar = this.f20405c.f20406a.L;
        sb.append(fVar);
        sb.append(" :: ");
        webView = this.f20405c.f20406a.H;
        sb.append(webView.getTitle());
        Log.d("HelpActivity", sb.toString());
        this.f20405c.a(this.f20404b, this.f20403a);
        gVar = this.f20405c.f20406a.N;
        gVar2 = this.f20405c.f20406a.O;
        if (gVar != gVar2) {
            toolbar2 = this.f20405c.f20406a.I;
            fVar4 = this.f20405c.f20406a.L;
            if (fVar4 != null) {
                fVar5 = this.f20405c.f20406a.L;
                title2 = fVar5.e();
            } else {
                webView3 = this.f20405c.f20406a.H;
                title2 = webView3.getTitle();
            }
            toolbar2.a(title2, 2);
            return;
        }
        toolbar = this.f20405c.f20406a.I;
        fVar2 = this.f20405c.f20406a.L;
        if (fVar2 != null) {
            fVar3 = this.f20405c.f20406a.L;
            title = fVar3.e();
        } else {
            webView2 = this.f20405c.f20406a.H;
            title = webView2.getTitle();
        }
        toolbar.a(title, 1);
    }
}
