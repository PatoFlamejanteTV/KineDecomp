package com.nextreaming.nexeditorui.newproject.b;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.newproject.b.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f4676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.f4676a = fVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Toolbar toolbar;
        a aVar;
        a aVar2;
        boolean z;
        f.a aVar3;
        a aVar4;
        Theme theme = (Theme) view.getTag();
        if (!theme.p()) {
            StringBuilder append = new StringBuilder().append("position : ").append(i).append("mSelectedThemePosition : ");
            aVar4 = this.f4676a.j;
            Log.d("bbong", append.append(aVar4.c()).toString());
            return;
        }
        toolbar = this.f4676a.h;
        toolbar.a(theme.a(this.f4676a.getActivity()), 1);
        aVar = this.f4676a.j;
        aVar.a(i);
        aVar2 = this.f4676a.j;
        aVar2.notifyDataSetChanged();
        this.f4676a.e = theme;
        z = this.f4676a.m;
        if (!z) {
            aVar3 = this.f4676a.l;
            aVar3.a(theme);
        }
    }
}
