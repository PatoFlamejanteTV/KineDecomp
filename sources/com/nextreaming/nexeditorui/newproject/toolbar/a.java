package com.nextreaming.nexeditorui.newproject.toolbar;

import android.view.MenuItem;
import com.nextreaming.nexeditorui.a.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToolbarLayout.java */
/* loaded from: classes.dex */
public class a implements a.InterfaceC0083a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ToolbarLayout f4750a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ToolbarLayout toolbarLayout) {
        this.f4750a = toolbarLayout;
    }

    @Override // com.nextreaming.nexeditorui.a.a.a.InterfaceC0083a
    public boolean a(MenuItem menuItem, int i) {
        a.InterfaceC0083a interfaceC0083a;
        a.InterfaceC0083a interfaceC0083a2;
        interfaceC0083a = this.f4750a.p;
        if (interfaceC0083a != null) {
            interfaceC0083a2 = this.f4750a.p;
            interfaceC0083a2.a(menuItem, i);
        }
        this.f4750a.e = i;
        return false;
    }
}
