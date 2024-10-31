package com.nexstreaming.kinemaster.ui.gdpr;

import android.view.View;
import android.widget.CheckBox;
import com.nexstreaming.kinemaster.ui.gdpr.g;

/* compiled from: GDPRFragment.java */
/* loaded from: classes.dex */
class c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f21590a;

    /* renamed from: b */
    final /* synthetic */ CheckBox f21591b;

    /* renamed from: c */
    final /* synthetic */ CheckBox f21592c;

    /* renamed from: d */
    final /* synthetic */ g f21593d;

    public c(g gVar, com.nexstreaming.kinemaster.ui.a.e eVar, CheckBox checkBox, CheckBox checkBox2) {
        this.f21593d = gVar;
        this.f21590a = eVar;
        this.f21591b = checkBox;
        this.f21592c = checkBox2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.a aVar;
        g.a aVar2;
        aVar = this.f21593d.f21600b;
        if (aVar != null) {
            aVar2 = this.f21593d.f21600b;
            aVar2.a(this.f21590a, this.f21591b.isChecked(), this.f21592c.isChecked());
        }
    }
}
