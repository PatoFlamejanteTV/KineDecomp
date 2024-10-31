package android.support.v7.widget;

import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Toolbar.java */
/* loaded from: classes.dex */
public class l implements ActionMenuView.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Toolbar f229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Toolbar toolbar) {
        this.f229a = toolbar;
    }

    @Override // android.support.v7.widget.ActionMenuView.e
    public boolean a(MenuItem menuItem) {
        Toolbar.c cVar;
        Toolbar.c cVar2;
        cVar = this.f229a.D;
        if (cVar == null) {
            return false;
        }
        cVar2 = this.f229a.D;
        return cVar2.a(menuItem);
    }
}
