package com.nextreaming.nexeditorui.newproject.b;

import android.view.View;
import android.widget.GridView;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nextreaming.nexeditorui.newproject.b.s;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes.dex */
public class r implements s.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f4680a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(f fVar) {
        this.f4680a = fVar;
    }

    @Override // com.nextreaming.nexeditorui.newproject.b.s.a
    public void a(Theme[] themeArr) {
        View view;
        GridView gridView;
        View view2;
        view = this.f4680a.f;
        if (view != null) {
            gridView = this.f4680a.i;
            gridView.setVisibility(0);
            view2 = this.f4680a.g;
            view2.setVisibility(8);
            this.f4680a.d = themeArr;
            this.f4680a.b();
        }
    }

    @Override // com.nextreaming.nexeditorui.newproject.b.s.a
    public void a(int i) {
        View view;
        View view2;
        GridView gridView;
        view = this.f4680a.g;
        if (view != null) {
            switch (i) {
                case 100:
                case 200:
                    view2 = this.f4680a.g;
                    view2.setVisibility(0);
                    break;
            }
            gridView = this.f4680a.i;
            gridView.setVisibility(0);
        }
    }
}
