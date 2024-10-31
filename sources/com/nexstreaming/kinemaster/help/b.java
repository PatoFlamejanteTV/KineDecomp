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
    final /* synthetic */ HelpActivity f20402a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HelpActivity helpActivity) {
        this.f20402a = helpActivity;
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
        gVar = this.f20402a.N;
        f fVar = (f) gVar.getItem(i);
        this.f20402a.L = fVar;
        if (!fVar.g() && fVar.f()) {
            this.f20402a.M = fVar.d();
            this.f20402a.N = fVar.c();
            gridView2 = this.f20402a.P;
            gVar2 = this.f20402a.N;
            gridView2.setAdapter((ListAdapter) gVar2);
            String replace = fVar.e().replace('\n', ' ');
            toolbar = this.f20402a.I;
            toolbar.a(replace, 1);
            gVar3 = this.f20402a.N;
            gVar3.notifyDataSetInvalidated();
            return;
        }
        if (fVar.g()) {
            this.f20402a.M = fVar.d();
        }
        webView = this.f20402a.H;
        webView.loadUrl(fVar.b());
        this.f20402a.J = true;
        gridView = this.f20402a.P;
        gridView.setVisibility(8);
    }
}
