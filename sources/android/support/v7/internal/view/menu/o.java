package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.e;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: SubMenuBuilder.java */
/* loaded from: classes.dex */
public class o extends e implements SubMenu {
    private e d;
    private f e;

    public o(Context context, e eVar, f fVar) {
        super(context);
        this.d = eVar;
        this.e = fVar;
    }

    @Override // android.support.v7.internal.view.menu.e, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.d.setQwertyMode(z);
    }

    @Override // android.support.v7.internal.view.menu.e
    public boolean a() {
        return this.d.a();
    }

    @Override // android.support.v7.internal.view.menu.e
    public boolean b() {
        return this.d.b();
    }

    public Menu o() {
        return this.d;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.e;
    }

    @Override // android.support.v7.internal.view.menu.e
    public void a(e.a aVar) {
        this.d.a(aVar);
    }

    @Override // android.support.v7.internal.view.menu.e
    public e l() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.internal.view.menu.e
    public boolean a(e eVar, MenuItem menuItem) {
        return super.a(eVar, menuItem) || this.d.a(eVar, menuItem);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.e.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.e.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        super.a(android.support.v4.a.a.a(d(), i));
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        super.a(d().getResources().getString(i));
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        super.a(view);
        return this;
    }

    @Override // android.support.v7.internal.view.menu.e
    public boolean c(f fVar) {
        return this.d.c(fVar);
    }

    @Override // android.support.v7.internal.view.menu.e
    public boolean d(f fVar) {
        return this.d.d(fVar);
    }
}
