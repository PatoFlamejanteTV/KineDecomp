package com.nextreaming.nexeditorui.newproject.b;

import android.content.DialogInterface;
import android.widget.GridView;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.newproject.b.f;

/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes.dex */
class p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Theme f4678a;
    final /* synthetic */ int b;
    final /* synthetic */ o c;

    public p(o oVar, Theme theme, int i) {
        this.c = oVar;
        this.f4678a = theme;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        a aVar;
        a aVar2;
        a aVar3;
        GridView gridView;
        Toolbar toolbar;
        f.a aVar4;
        this.f4678a.x();
        aVar = this.c.f4677a.j;
        if (aVar != null) {
            aVar2 = this.c.f4677a.j;
            if (aVar2.c() == this.b) {
                gridView = this.c.f4677a.i;
                gridView.clearChoices();
                toolbar = this.c.f4677a.h;
                toolbar.a(1);
                this.c.f4677a.e = null;
                aVar4 = this.c.f4677a.l;
                aVar4.b();
            }
            aVar3 = this.c.f4677a.j;
            aVar3.notifyDataSetChanged();
        }
        dialogInterface.dismiss();
    }
}
