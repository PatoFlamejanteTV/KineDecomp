package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubMenuWrapperICS.java */
/* loaded from: classes.dex */
public class p extends n implements SubMenu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context, android.support.v4.c.a.c cVar) {
        super(context, cVar);
    }

    public android.support.v4.c.a.c b() {
        return (android.support.v4.c.a.c) this.b;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        b().setHeaderTitle(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        b().setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        b().setHeaderIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        b().setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        b().setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        b().clearHeader();
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        b().setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        b().setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return a(b().getItem());
    }
}
