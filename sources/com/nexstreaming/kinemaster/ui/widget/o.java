package com.nexstreaming.kinemaster.ui.widget;

import android.view.MenuItem;
import com.nextreaming.nexeditorui.a.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Toolbar.java */
/* loaded from: classes.dex */
public class o implements a.InterfaceC0083a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Toolbar f4401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Toolbar toolbar) {
        this.f4401a = toolbar;
    }

    @Override // com.nextreaming.nexeditorui.a.a.a.InterfaceC0083a
    public boolean a(MenuItem menuItem, int i) {
        a.InterfaceC0083a interfaceC0083a;
        a.InterfaceC0083a interfaceC0083a2;
        interfaceC0083a = this.f4401a.v;
        if (interfaceC0083a != null) {
            interfaceC0083a2 = this.f4401a.v;
            interfaceC0083a2.a(menuItem, i);
        }
        this.f4401a.t = i;
        return false;
    }
}
