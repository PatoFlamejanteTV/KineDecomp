package com.nexstreaming.kinemaster.ui.widget;

import android.view.View;

/* compiled from: Toolbar.java */
/* loaded from: classes2.dex */
public class t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Toolbar f23889a;

    public t(Toolbar toolbar) {
        this.f23889a = toolbar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        com.nextreaming.nexeditorui.a.a.b bVar;
        com.nextreaming.nexeditorui.a.a.b bVar2;
        int i;
        com.nextreaming.nexeditorui.a.a.b bVar3;
        com.nextreaming.nexeditorui.a.a.b bVar4;
        z = this.f23889a.v;
        if (z) {
            return;
        }
        bVar = this.f23889a.t;
        if (bVar != null) {
            bVar4 = this.f23889a.t;
            if (bVar4.c()) {
                return;
            }
        }
        bVar2 = this.f23889a.t;
        i = this.f23889a.u;
        bVar2.b(i);
        bVar3 = this.f23889a.t;
        bVar3.d();
    }
}
