package com.nextreaming.nexeditorui.newproject.b;

import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.newproject.b.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes3.dex */
public class f implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f24355a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(g gVar) {
        this.f24355a = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Toolbar toolbar;
        c cVar;
        c cVar2;
        boolean z;
        g.a aVar;
        c.d.b.i.a aVar2 = (c.d.b.i.a) view.getTag(R.id.theme_browser_tag_key_theme);
        toolbar = this.f24355a.f24359d;
        toolbar.a(aVar2.getName(this.f24355a.getActivity()), 1);
        cVar = this.f24355a.f24361f;
        cVar.a(i);
        cVar2 = this.f24355a.f24361f;
        cVar2.notifyDataSetChanged();
        this.f24355a.f24357b = aVar2;
        z = this.f24355a.f24363h;
        if (z) {
            return;
        }
        aVar = this.f24355a.f24362g;
        aVar.a(aVar2);
    }
}
