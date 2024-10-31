package com.nextreaming.nexeditorui.newproject.b;

import android.view.View;
import android.widget.GridView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.newproject.b.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f4674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.f4674a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Toolbar toolbar;
        GridView gridView;
        a aVar;
        f.a aVar2;
        Toolbar toolbar2;
        f.a aVar3;
        Theme theme;
        switch (view.getId()) {
            case R.id.deleteIcon /* 2131821583 */:
                toolbar = this.f4674a.h;
                if (toolbar != null) {
                    toolbar2 = this.f4674a.h;
                    toolbar2.a(1);
                }
                gridView = this.f4674a.i;
                gridView.clearChoices();
                aVar = this.f4674a.j;
                aVar.notifyDataSetChanged();
                this.f4674a.e = null;
                aVar2 = this.f4674a.l;
                aVar2.b();
                return;
            case R.id.accept_button /* 2131821587 */:
                aVar3 = this.f4674a.l;
                theme = this.f4674a.e;
                aVar3.a(theme);
                this.f4674a.getFragmentManager().popBackStackImmediate();
                return;
            default:
                return;
        }
    }
}
