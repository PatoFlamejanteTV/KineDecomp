package com.nexstreaming.kinemaster.help;

import android.util.Log;
import android.webkit.WebView;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* compiled from: HelpActivity.java */
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3399a;
    final /* synthetic */ WebView b;
    final /* synthetic */ c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, WebView webView) {
        this.c = cVar;
        this.f3399a = str;
        this.b = webView;
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
        StringBuilder append = new StringBuilder().append("TESTTEST :: onPageFinished :: ").append(this.f3399a).append(" :: ");
        fVar = this.c.f3398a.f;
        StringBuilder append2 = append.append(fVar).append(" :: ");
        webView = this.c.f3398a.f3395a;
        Log.d("HelpActivity", append2.append(webView.getTitle()).toString());
        this.c.a(this.b, this.f3399a);
        gVar = this.c.f3398a.h;
        gVar2 = this.c.f3398a.i;
        if (gVar != gVar2) {
            toolbar2 = this.c.f3398a.b;
            fVar4 = this.c.f3398a.f;
            if (fVar4 != null) {
                fVar5 = this.c.f3398a.f;
                title2 = fVar5.a();
            } else {
                webView3 = this.c.f3398a.f3395a;
                title2 = webView3.getTitle();
            }
            toolbar2.a(title2, 2);
            return;
        }
        toolbar = this.c.f3398a.b;
        fVar2 = this.c.f3398a.f;
        if (fVar2 != null) {
            fVar3 = this.c.f3398a.f;
            title = fVar3.a();
        } else {
            webView2 = this.c.f3398a.f3395a;
            title = webView2.getTitle();
        }
        toolbar.a(title, 1);
    }
}
