package com.nexstreaming.kinemaster.help;

import android.view.View;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* compiled from: HelpActivity.java */
/* loaded from: classes.dex */
class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HelpActivity f3396a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HelpActivity helpActivity) {
        this.f3396a = helpActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridView gridView;
        g gVar;
        g gVar2;
        g gVar3;
        GridView gridView2;
        g gVar4;
        Toolbar toolbar;
        g gVar5;
        WebView webView;
        GridView gridView3;
        WebView webView2;
        Toolbar toolbar2;
        WebView webView3;
        GridView gridView4;
        WebView webView4;
        GridView gridView5;
        WebView webView5;
        g gVar6;
        g gVar7;
        Toolbar toolbar3;
        Toolbar toolbar4;
        if (view.getId() == R.id.menu_subtitle1_holder) {
            webView3 = this.f3396a.f3395a;
            if (webView3.getVisibility() == 0) {
                gridView4 = this.f3396a.j;
                if (gridView4.getVisibility() == 8) {
                    webView4 = this.f3396a.f3395a;
                    webView4.clearCache(true);
                    gridView5 = this.f3396a.j;
                    gridView5.setVisibility(0);
                    webView5 = this.f3396a.f3395a;
                    webView5.setVisibility(8);
                    gVar6 = this.f3396a.h;
                    gVar7 = this.f3396a.i;
                    if (gVar6 != gVar7) {
                        toolbar4 = this.f3396a.b;
                        toolbar4.a(2);
                        return;
                    } else {
                        toolbar3 = this.f3396a.b;
                        toolbar3.a(1);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (view.getId() == R.id.titleHolder) {
            gridView = this.f3396a.j;
            if (gridView.getVisibility() == 8) {
                webView = this.f3396a.f3395a;
                webView.clearCache(true);
                gridView3 = this.f3396a.j;
                gridView3.setVisibility(0);
                webView2 = this.f3396a.f3395a;
                webView2.setVisibility(8);
                toolbar2 = this.f3396a.b;
                toolbar2.a(1);
            }
            gVar = this.f3396a.h;
            gVar2 = this.f3396a.i;
            if (gVar != gVar2) {
                this.f3396a.f = null;
                HelpActivity helpActivity = this.f3396a;
                gVar3 = this.f3396a.i;
                helpActivity.h = gVar3;
                this.f3396a.g = -1;
                gridView2 = this.f3396a.j;
                gVar4 = this.f3396a.h;
                gridView2.setAdapter((ListAdapter) gVar4);
                toolbar = this.f3396a.b;
                toolbar.a(1);
                gVar5 = this.f3396a.h;
                gVar5.notifyDataSetInvalidated();
            }
        }
    }
}
