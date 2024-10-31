package com.nexstreaming.kinemaster.help;

import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* compiled from: HelpActivity.java */
/* loaded from: classes.dex */
class b implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HelpActivity f3397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HelpActivity helpActivity) {
        this.f3397a = helpActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        WebView webView;
        GridView gridView;
        GridView gridView2;
        g gVar2;
        Toolbar toolbar;
        g gVar3;
        gVar = this.f3397a.h;
        f fVar = (f) gVar.getItem(i);
        this.f3397a.f = fVar;
        if (!fVar.e() && fVar.f()) {
            this.f3397a.g = fVar.g();
            this.f3397a.h = fVar.d();
            gridView2 = this.f3397a.j;
            gVar2 = this.f3397a.h;
            gridView2.setAdapter((ListAdapter) gVar2);
            String replace = fVar.a().replace('\n', ' ');
            toolbar = this.f3397a.b;
            toolbar.a(replace, 1);
            gVar3 = this.f3397a.h;
            gVar3.notifyDataSetInvalidated();
            return;
        }
        if (fVar.e()) {
            this.f3397a.g = fVar.g();
        }
        webView = this.f3397a.f3395a;
        webView.loadUrl(fVar.b());
        this.f3397a.c = true;
        gridView = this.f3397a.j;
        gridView.setVisibility(8);
    }
}
