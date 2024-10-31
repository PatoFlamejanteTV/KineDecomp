package com.nextreaming.nexeditorui.newproject.toolbar;

import android.view.MenuItem;
import com.nextreaming.nexeditorui.a.a.b;

/* compiled from: ToolbarLayout.java */
/* loaded from: classes3.dex */
public class a implements b.a {

    /* renamed from: a */
    final /* synthetic */ ToolbarLayout f24381a;

    public a(ToolbarLayout toolbarLayout) {
        this.f24381a = toolbarLayout;
    }

    @Override // com.nextreaming.nexeditorui.a.a.b.a
    public void a(MenuItem menuItem, int i) {
        b.a aVar;
        b.a aVar2;
        aVar = this.f24381a.p;
        if (aVar != null) {
            aVar2 = this.f24381a.p;
            aVar2.a(menuItem, i);
        }
        this.f24381a.f24377e = i;
    }
}
