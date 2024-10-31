package com.nexstreaming.kinemaster.ui.widget;

import android.view.MenuItem;
import com.nextreaming.nexeditorui.a.a.b;

/* compiled from: Toolbar.java */
/* loaded from: classes2.dex */
public class s implements b.a {

    /* renamed from: a */
    final /* synthetic */ Toolbar f23888a;

    public s(Toolbar toolbar) {
        this.f23888a = toolbar;
    }

    @Override // com.nextreaming.nexeditorui.a.a.b.a
    public void a(MenuItem menuItem, int i) {
        b.a aVar;
        b.a aVar2;
        aVar = this.f23888a.w;
        if (aVar != null) {
            aVar2 = this.f23888a.w;
            aVar2.a(menuItem, i);
        }
        if (menuItem.isCheckable()) {
            this.f23888a.u = i;
        }
    }
}
