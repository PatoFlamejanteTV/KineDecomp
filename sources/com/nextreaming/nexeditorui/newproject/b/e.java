package com.nextreaming.nexeditorui.newproject.b;

import android.view.View;
import android.widget.GridView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.newproject.b.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes3.dex */
public class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f24354a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar) {
        this.f24354a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.a aVar;
        c.d.b.i.a aVar2;
        Toolbar toolbar;
        GridView gridView;
        c cVar;
        g.a aVar3;
        Toolbar toolbar2;
        int id = view.getId();
        if (id == R.id.accept_button) {
            aVar = this.f24354a.f24362g;
            aVar2 = this.f24354a.f24357b;
            aVar.a(aVar2);
            this.f24354a.getFragmentManager().popBackStackImmediate();
            return;
        }
        if (id != R.id.deleteIcon) {
            return;
        }
        toolbar = this.f24354a.f24359d;
        if (toolbar != null) {
            toolbar2 = this.f24354a.f24359d;
            toolbar2.a(1);
        }
        gridView = this.f24354a.f24360e;
        gridView.clearChoices();
        cVar = this.f24354a.f24361f;
        cVar.notifyDataSetChanged();
        this.f24354a.f24357b = null;
        aVar3 = this.f24354a.f24362g;
        aVar3.r();
    }
}
