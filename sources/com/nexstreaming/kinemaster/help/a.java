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
    final /* synthetic */ HelpActivity f20401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HelpActivity helpActivity) {
        this.f20401a = helpActivity;
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
            webView3 = this.f20401a.H;
            if (webView3.getVisibility() == 0) {
                gridView4 = this.f20401a.P;
                if (gridView4.getVisibility() == 8) {
                    webView4 = this.f20401a.H;
                    webView4.clearCache(true);
                    gridView5 = this.f20401a.P;
                    gridView5.setVisibility(0);
                    webView5 = this.f20401a.H;
                    webView5.setVisibility(8);
                    gVar6 = this.f20401a.N;
                    gVar7 = this.f20401a.O;
                    if (gVar6 != gVar7) {
                        toolbar4 = this.f20401a.I;
                        toolbar4.a(2);
                        return;
                    } else {
                        toolbar3 = this.f20401a.I;
                        toolbar3.a(1);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (view.getId() == R.id.titleHolder) {
            gridView = this.f20401a.P;
            if (gridView.getVisibility() == 8) {
                webView = this.f20401a.H;
                webView.clearCache(true);
                gridView3 = this.f20401a.P;
                gridView3.setVisibility(0);
                webView2 = this.f20401a.H;
                webView2.setVisibility(8);
                toolbar2 = this.f20401a.I;
                toolbar2.a(1);
            }
            gVar = this.f20401a.N;
            gVar2 = this.f20401a.O;
            if (gVar != gVar2) {
                this.f20401a.L = null;
                HelpActivity helpActivity = this.f20401a;
                gVar3 = helpActivity.O;
                helpActivity.N = gVar3;
                this.f20401a.M = -1;
                gridView2 = this.f20401a.P;
                gVar4 = this.f20401a.N;
                gridView2.setAdapter((ListAdapter) gVar4);
                toolbar = this.f20401a.I;
                toolbar.a(1);
                gVar5 = this.f20401a.N;
                gVar5.notifyDataSetInvalidated();
            }
        }
    }
}
