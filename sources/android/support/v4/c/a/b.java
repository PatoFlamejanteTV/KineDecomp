package android.support.v4.c.a;

import android.support.v4.g.k;
import android.view.MenuItem;
import android.view.View;

/* compiled from: SupportMenuItem.java */
/* loaded from: classes.dex */
public interface b extends MenuItem {
    b a(android.support.v4.g.a aVar);

    b a(k.e eVar);

    android.support.v4.g.a a();

    @Override // android.view.MenuItem
    boolean collapseActionView();

    @Override // android.view.MenuItem
    boolean expandActionView();

    @Override // android.view.MenuItem
    View getActionView();

    @Override // android.view.MenuItem
    boolean isActionViewExpanded();

    @Override // android.view.MenuItem
    MenuItem setActionView(int i);

    @Override // android.view.MenuItem
    MenuItem setActionView(View view);

    @Override // android.view.MenuItem
    void setShowAsAction(int i);

    @Override // android.view.MenuItem
    MenuItem setShowAsActionFlags(int i);
}
