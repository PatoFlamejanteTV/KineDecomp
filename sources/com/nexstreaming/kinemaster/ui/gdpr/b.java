package com.nexstreaming.kinemaster.ui.gdpr;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.nexstreaming.kinemaster.ui.gdpr.g;

/* compiled from: GDPRFragment.java */
/* loaded from: classes.dex */
class b implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ g f21589a;

    public b(g gVar) {
        this.f21589a = gVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        g.a aVar;
        g.a aVar2;
        if (i != 4) {
            return false;
        }
        aVar = this.f21589a.f21600b;
        if (aVar == null || !this.f21589a.isCancelable()) {
            return false;
        }
        aVar2 = this.f21589a.f21600b;
        aVar2.a(dialogInterface);
        return true;
    }
}
