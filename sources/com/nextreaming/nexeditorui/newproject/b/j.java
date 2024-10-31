package com.nextreaming.nexeditorui.newproject.b;

import android.widget.GridView;
import com.nexstreaming.kinemaster.kmpackage.Theme;

/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f4672a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f4672a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        GridView gridView2;
        Theme theme;
        int b;
        gridView = this.f4672a.f4671a.i;
        if (gridView != null) {
            gridView2 = this.f4672a.f4671a.i;
            f fVar = this.f4672a.f4671a;
            theme = this.f4672a.f4671a.e;
            b = fVar.b(theme);
            gridView2.setItemChecked(b, true);
        }
    }
}
