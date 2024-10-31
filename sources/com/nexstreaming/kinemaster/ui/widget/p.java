package com.nexstreaming.kinemaster.ui.widget;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Toolbar.java */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Toolbar f4402a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Toolbar toolbar) {
        this.f4402a = toolbar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        com.nextreaming.nexeditorui.a.a.a aVar;
        com.nextreaming.nexeditorui.a.a.a aVar2;
        int i;
        com.nextreaming.nexeditorui.a.a.a aVar3;
        com.nextreaming.nexeditorui.a.a.a aVar4;
        z = this.f4402a.u;
        if (!z) {
            aVar = this.f4402a.s;
            if (aVar != null) {
                aVar4 = this.f4402a.s;
                if (aVar4.d()) {
                    return;
                }
            }
            aVar2 = this.f4402a.s;
            i = this.f4402a.t;
            aVar2.b(i);
            aVar3 = this.f4402a.s;
            aVar3.b();
        }
    }
}
