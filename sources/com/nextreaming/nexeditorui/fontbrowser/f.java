package com.nextreaming.nexeditorui.fontbrowser;

import android.content.DialogInterface;
import android.view.View;
import com.nexstreaming.kinemaster.kmpackage.Font;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes.dex */
class f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.a f4630a;
    final /* synthetic */ Font b;
    final /* synthetic */ View c;
    final /* synthetic */ e d;

    public f(e eVar, com.nexstreaming.kinemaster.ui.a.a aVar, Font font, View view) {
        this.d = eVar;
        this.f4630a = aVar;
        this.b = font;
        this.c = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4630a.a(-2, false);
        this.f4630a.a(-1, false);
        this.b.l().onComplete(new g(this));
    }
}
